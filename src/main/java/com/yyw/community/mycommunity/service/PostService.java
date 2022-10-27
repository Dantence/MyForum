package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.dto.PostQueryDTO;
import com.yyw.community.mycommunity.entity.Post;
import com.yyw.community.mycommunity.entity.PostExample;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.ActionExp;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.PostExtMapper;
import com.yyw.community.mycommunity.mapper.PostMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dantence
 * @date 2022/7/7
 * 2022/7/10 使用mybatis-generator进行迁移，使用rowbounds模型进行分页
 */
@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 查出所有的post之后，根据post的publisher查出user，组装成postDTO
     *
     * @param page
     * @param size
     * @return
     */
    public PaginationDTO<PostDTO> list(String search, String tag, Integer page, Integer size) {
        if(!StringUtils.isEmpty(search)){
            String[] keys = StringUtils.split(search, " ");
            search = String.join("|", keys);
        }
        Integer offset = size * (page - 1);
        PostQueryDTO postQueryDTO = new PostQueryDTO();
        postQueryDTO.setSearch(search);
        postQueryDTO.setTag(tag);

        Integer totalCount = postExtMapper.countBySearch(postQueryDTO);
        postQueryDTO.setPage(offset);
        postQueryDTO.setSize(size);
        List<Post> posts = postExtMapper.selectBySearch(postQueryDTO);
        List<PostDTO> postDTOList = new ArrayList<>();
        PaginationDTO <PostDTO> paginationDTO = new PaginationDTO<>();
        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getPublisher());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        paginationDTO.setPagination(totalCount, page, size);
        paginationDTO.setData(postDTOList);
        return paginationDTO;
    }

    public PaginationDTO<PostDTO> list(Long userId, Integer page, Integer size) {
        Integer offset = size * (page - 1);
        PostExample example = new PostExample();
        example.createCriteria().andPublisherEqualTo(userId);
        List<Post> posts = postMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<PostDTO> postDTOList = new ArrayList<>();
        PaginationDTO <PostDTO> paginationDTO = new PaginationDTO<>();
        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getPublisher());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPublisherEqualTo(userId);
        Integer totalCount = (int) postMapper.countByExample(postExample);
        paginationDTO.setPagination(totalCount, page, size);
        paginationDTO.setData(postDTOList);
        return paginationDTO;
    }

    public PostDTO selectById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null) {
            throw new CustomizeException(CustomizeErrorCodeImpl.POST_NOT_FOUND);
        }
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        User user = userMapper.selectByPrimaryKey(post.getPublisher());
        postDTO.setUser(user);
        return postDTO;
    }

    /**
     * 用于处理到底是首次发布还是编辑之后更新
     *
     * @param post
     */
    @Transactional
    public void handlePublish(Post post) {
        if (post.getId() == null) {
            post.setLikesCount(0L);
            post.setViewCount(0L);
            post.setCommentCount(0L);
            post.setGmtCreate(System.currentTimeMillis());
            post.setGmtModified(post.getGmtCreate());
            postMapper.insert(post);
            userService.updateLevel(ActionExp.PUBLISH.getExp(), post.getPublisher());
        } else {
            Post updatePost = new Post();
            updatePost.setGmtModified(System.currentTimeMillis());
            updatePost.setTitle(post.getTitle());
            updatePost.setContent(post.getContent());
            updatePost.setTag(post.getTag());
            PostExample example = new PostExample();
            example.createCriteria().
                    andIdEqualTo(post.getId());
            int rows = postMapper.updateByExampleSelective(updatePost, example);
            if (rows != 1) {
                throw new CustomizeException(CustomizeErrorCodeImpl.POST_NOT_FOUND);
            }
        }
    }

    /**
     * 用于增加阅读数，采用自增方式保证数据一致性
     *
     * @param id
     */
    public void increaseViewCount(Long id) {
        Post post = new Post();
        post.setId(id);
        post.setViewCount(1L);
        int rows = postExtMapper.increaseViewCount(post);
    }

    public List<PostDTO> selectRelated(PostDTO postDTO) {
        if (StringUtils.isEmpty(postDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(postDTO.getTag(), ",");
        String regexpTag = String.join("|", tags);
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTag(regexpTag);
        List<Post> posts = postExtMapper.selectRelated(post);
        return posts.stream().map(q -> {
            PostDTO dto = new PostDTO();
            BeanUtils.copyProperties(q, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public Long postCount(Long id) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPublisherEqualTo(id);
        return postMapper.countByExample(postExample);
    }
}
