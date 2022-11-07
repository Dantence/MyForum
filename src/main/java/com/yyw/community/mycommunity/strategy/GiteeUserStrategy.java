package com.yyw.community.mycommunity.strategy;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import com.yyw.community.mycommunity.dto.AccessTokenDTO;
import com.yyw.community.mycommunity.provider.GiteeProvider;
import com.yyw.community.mycommunity.provider.dto.GitHubUser;
import com.yyw.community.mycommunity.provider.dto.GiteeUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.strategy
 * @className: GiteeUserStrategy
 * @author: Dantence
 * @description: gitee平台登录策略
 * @date: 2022/11/7 20:36
 * @version: 1.0
 */
public class GiteeUserStrategy implements UserStrategy {
    @Autowired
    private GiteeProvider giteeProvider;
    @Override
    public LoginUserInfo getUser(String code, String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = giteeProvider.getAccessToken(accessTokenDTO);
        GiteeUser giteeUser = giteeProvider.getGiteeUser(accessToken);
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setAvatarUrl(giteeUser.getAvatarUrl());
        loginUserInfo.setBio(giteeUser.getBio());
        loginUserInfo.setName(giteeUser.getName());
        loginUserInfo.setId(giteeUser.getId());
        return loginUserInfo;
    }

    @Override
    public String getSupportedType() {
        return "gitee";
    }
}
