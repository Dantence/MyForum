package com.yyw.community.mycommunity.dto;

import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/21
 */
@Data
public class PostQueryDTO {
    private String search;
    private String tag;
    private Integer page;
    private Integer size;
}
