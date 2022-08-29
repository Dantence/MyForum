package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.User;
import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/20
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private String notifierName;
    private Long notifier;
    private String outerTitle;
    private Long outerId;
    private String typeName;
    private Integer type;
}
