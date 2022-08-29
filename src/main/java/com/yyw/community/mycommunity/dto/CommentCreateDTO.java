package com.yyw.community.mycommunity.dto;

import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/12
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
