package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.dto.PostQueryDTO;
import com.yyw.community.mycommunity.entity.Post;
import com.yyw.community.mycommunity.entity.PostExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/12
 */
public interface PostExtMapper {
    int increaseViewCount(Post post);
    int increaseCommentCount(Post post);
    List<Post> selectRelated(Post post);
    Integer countBySearch(PostQueryDTO postQueryDTO);

    List<Post> selectBySearch(PostQueryDTO postQueryDTO);
}
