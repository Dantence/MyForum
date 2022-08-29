package com.yyw.community.mycommunity.dto;

import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/24
 */
@Data
public class MessageNewDTO {
    private Long id;
    private Long creatorId;
    private String creatorName;
    private String action;
    private Integer status;
}
