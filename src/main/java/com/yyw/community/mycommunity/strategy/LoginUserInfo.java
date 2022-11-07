package com.yyw.community.mycommunity.strategy;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import lombok.Data;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.strategy
 * @className: LoginUserInfo
 * @author: Dantence
 * @description: 用户登录信息
 * @date: 2022/11/7 20:28
 * @version: 1.0
 */
@Data
public class LoginUserInfo {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
