package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.Comment;

/**
 * @author Dantence
 * @date 2022/7/19
 */
public interface CommentExtMapper {
    int increaseCommentCount(Comment comment);
    int increaseLikesCount(Comment comment);
    int decreaseLikesCount(Comment comment);
}
