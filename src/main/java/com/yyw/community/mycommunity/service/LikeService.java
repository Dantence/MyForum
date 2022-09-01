package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.entity.Likes;
import com.yyw.community.mycommunity.entity.LikesExample;

import com.yyw.community.mycommunity.mapper.LikesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/8/31
 */
@Service
public class LikeService {
    @Autowired
    private LikesMapper likesMapper;

    public Integer isLiked(Long userId, Long commentId) {
        LikesExample likeExample = new LikesExample();
        LikesExample.Criteria criteria = likeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCommentIdEqualTo(commentId);
        List<Likes> res = likesMapper.selectByExample(likeExample);
        if (res.size() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int insert(Long userId, Long commentId) {
        Likes likes = new Likes();
        Long time = System.currentTimeMillis();
        likes.setGmtCreated(time);
        likes.setGmtModified(time);
        likes.setUserId(userId);
        likes.setCommentId(commentId);
        return likesMapper.insert(likes);
    }

    public Integer delete(Long userId, Long commentId) {
        LikesExample likeExample = new LikesExample();
        likeExample.createCriteria().andUserIdEqualTo(userId).andCommentIdEqualTo(commentId);
        return likesMapper.deleteByExample(likeExample);
    }
}
