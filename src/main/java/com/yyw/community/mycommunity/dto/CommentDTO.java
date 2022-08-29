package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.User;
import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/12
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private String content;
    private Integer type;
    private Long commentator;
    private Long likesCount;
    private Long commentCount;
    private Long gmtCreate;
    private Long gmtModified;
    private User user;
}
