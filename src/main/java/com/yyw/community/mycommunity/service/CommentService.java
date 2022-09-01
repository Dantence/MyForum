package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.CommentDTO;
import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.enums.CommentTypeEnum;
import com.yyw.community.mycommunity.enums.NotificationStatusEnum;
import com.yyw.community.mycommunity.enums.NotificationTypeEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dantence
 * @date 2022/7/12 回复帖子/评论
 *       2022/7/13 添加事务注解
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    @Autowired
    private NotificationMapper notificationMapper;

    @Transactional
    public void insert(Comment comment, User commentator) {
        if(comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCodeImpl.TYPE_PARAM_ERROR);
        }
        if(comment.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCodeImpl.COMMENT_NOT_FOUND);
            } else {
                Post post = postMapper.selectByPrimaryKey(dbComment.getParentId());
                if (post == null) {
                    throw new CustomizeException(CustomizeErrorCodeImpl.POST_NOT_FOUND);
                }
                commentMapper.insert(comment);

                //增加评论数
                Comment parentComment = new Comment();
                parentComment.setId(comment.getParentId());
                parentComment.setCommentCount(1L);
                commentExtMapper.increaseCommentCount(parentComment);

                //创建通知
                createNotification(comment, dbComment.getCommentator(), commentator.getName(), post.getTitle(), NotificationTypeEnum.REPLY_COMMENT, post.getId());
            }
        }
        else if(comment.getType().equals(CommentTypeEnum.POST.getType())) {
            //回复帖子
            Post post = postMapper.selectByPrimaryKey(comment.getParentId());
            if (post == null) {
                throw new CustomizeException(CustomizeErrorCodeImpl.POST_NOT_FOUND);
            } else {
                comment.setCommentCount(0L);
                commentMapper.insert(comment);
                post.setCommentCount(1L);
                postExtMapper.increaseCommentCount(post);

                createNotification(comment, post.getPublisher(), commentator.getName(), post.getTitle(), NotificationTypeEnum.REPLY_POST, post.getId());
            }
        }
    }

    private void createNotification(Comment comment, Long receiver, String notifierName, String outerTitle,
                                    NotificationTypeEnum notificationTypeEnum, Long outerId) {
        if(receiver.equals(comment.getCommentator())){
            return;
        }
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notification.getType());
        notification.setOuterId(outerId);
        notification.setNotifier(comment.getCommentator());
        notification.setReceiver(receiver);
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setNotifierName(notifierName);
        notification.setOuterTitle(outerTitle);
        notification.setType(notificationTypeEnum.getType());
        notificationMapper.insert(notification);
    }

    public List<CommentDTO> selectByTargetId(Long id, Integer type) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(type);
        example.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(example);
        if(comments.size() == 0) {
            return new ArrayList<>();
        }
        //获取去重的评论人
        List<Long> userIds = comments.stream().map(Comment::getCommentator).distinct().collect(Collectors.toList());

        //获取评论人并转化为map
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(userIds);
        List<User> users= userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, user -> user));

        //转换comment为commentDTO
        return comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());
    }

    public Long like(Long id) {
        Comment target = commentMapper.selectByPrimaryKey(id);
        if(target == null){
            throw new CustomizeException(CustomizeErrorCodeImpl.COMMENT_NOT_FOUND);
        }
        Comment comment = new Comment();
        comment.setId(id);
        comment.setLikesCount(1L);
        commentExtMapper.increaseLikesCount(comment);
        return target.getLikesCount() + 1;
    }

    public Long unlike(Long id) {
        Comment target = commentMapper.selectByPrimaryKey(id);
        if(target == null){
            throw new CustomizeException(CustomizeErrorCodeImpl.COMMENT_NOT_FOUND);
        }
        Comment comment = new Comment();
        comment.setId(id);
        comment.setLikesCount(1L);
        commentExtMapper.decreaseLikesCount(comment);
        return target.getLikesCount() - 1;
    }
}
