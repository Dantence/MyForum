package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.mapper.FavorMapper;
import com.yyw.community.mycommunity.mapper.PostExtMapper;
import com.yyw.community.mycommunity.mapper.PostMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/8/31
 */
@Service
public class FavorService {
    @Autowired
    private FavorMapper favorMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private UserMapper userMapper;

    public Integer isFavored(Long UserId, Long postId){
        FavorExample favorExample = new FavorExample();
        favorExample.createCriteria().andUserIdEqualTo(UserId).andPostIdEqualTo(postId);
        List<Favor> res = favorMapper.selectByExample(favorExample);
        if(res.size() == 0){
            return 0;
        } else {
            return 1;
        }
    }

    @Transactional
    public int favor(Long userId, Long postId) {
        Favor favor = new Favor();
        favor.setUserId(userId);
        favor.setPostId(postId);
        favor.setGmtCreate(System.currentTimeMillis());
        Post post = new Post();
        post.setId(postId);
        post.setLikesCount(1L);
        postExtMapper.increaseLikesCount(post);
        return favorMapper.insert(favor);
    }

    public int unFavor(Long userId, Long postId) {
        FavorExample favorExample = new FavorExample();
        favorExample.createCriteria().andUserIdEqualTo(userId).andPostIdEqualTo(postId);
        Post post = new Post();
        post.setId(postId);
        post.setLikesCount(1L);
        postExtMapper.decreaseLikesCount(post);
        return favorMapper.deleteByExample(favorExample);
    }

    public PaginationDTO<PostDTO> list(Long userId, Integer page, Integer size) {
        Integer offset = size * (page - 1);
        FavorExample favorExample = new FavorExample();
        favorExample.createCriteria().andUserIdEqualTo(userId);
        favorExample.setOrderByClause("gmt_create desc");
        Integer totalCount = (int) favorMapper.countByExample(favorExample);
        List<Favor> favors = favorMapper.selectByExampleWithRowbounds(favorExample, new RowBounds(offset, size));
        List<PostDTO> postDTOs = new ArrayList<>();
        PaginationDTO<PostDTO> paginationDTO = new PaginationDTO<>();
        paginationDTO.setPagination(totalCount, page, size);
        if(favors.size() == 0){
            return paginationDTO;
        }
        for(Favor favor : favors){
            PostDTO postDTO = new PostDTO();
            Post post = postMapper.selectByPrimaryKey(favor.getPostId());
            User user = userMapper.selectByPrimaryKey(post.getPublisher());
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOs.add(postDTO);
        }
        paginationDTO.setData(postDTOs);
        return paginationDTO;
    }

}
