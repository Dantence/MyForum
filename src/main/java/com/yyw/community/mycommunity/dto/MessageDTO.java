package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.Message;
import com.yyw.community.mycommunity.entity.User;
import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/22
 */
@Data
public class MessageDTO {
    private Long id;
    private Long creator;
    private Long receiver;
    private String content;
    private Integer status;
    private Long gmtCreate;
    private User user;
}
