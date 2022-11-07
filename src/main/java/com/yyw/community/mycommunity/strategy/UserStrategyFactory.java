package com.yyw.community.mycommunity.strategy;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.strategy
 * @className: UserStrategyFactory
 * @author: Dantence
 * @description: 用户登录策略工厂
 * @date: 2022/11/7 21:23
 * @version: 1.0
 */
@Service
public class UserStrategyFactory {
    @Autowired
    private List<UserStrategy> strategies;

    public UserStrategy getStratgety(String type){
        for(UserStrategy strategy : strategies){
            if(StringUtils.equals(strategy.getSupportedType(), type)){
                return strategy;
            }
        }
        return null;
    }
}
