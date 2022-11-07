package com.yyw.community.mycommunity.strategy;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.strategy
 * @className: UserStrategy
 * @author: Dantence
 * @description: 用户登录策略接口
 * @date: 2022/11/7 20:27
 * @version: 1.0
 */
public interface UserStrategy {
    LoginUserInfo getUser(String code, String state);
    String getSupportedType();
}
