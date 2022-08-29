package com.yyw.community.mycommunity.dto;

import lombok.Data;
/**
 * @author Dantence
 * @date 2022/7/6
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
