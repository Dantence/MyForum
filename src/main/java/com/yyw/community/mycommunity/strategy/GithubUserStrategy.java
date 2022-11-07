package com.yyw.community.mycommunity.strategy;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import com.yyw.community.mycommunity.dto.AccessTokenDTO;
import com.yyw.community.mycommunity.provider.dto.GitHubUser;
import com.yyw.community.mycommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.strategy
 * @className: GithubUserStrategy
 * @author: Dantence
 * @description: github平台登录策略
 * @date: 2022/11/7 20:31
 * @version: 1.0
 */
@Service
public class GithubUserStrategy implements UserStrategy {
    @Autowired
    private GitHubProvider gitHubProvider;


    @Override
    public LoginUserInfo getUser(String code, String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getGitHubUser(accessToken);
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setAvatarUrl(gitHubUser.getAvatarUrl());
        loginUserInfo.setBio(gitHubUser.getBio());
        loginUserInfo.setName(gitHubUser.getName());
        loginUserInfo.setId(gitHubUser.getId());
        return loginUserInfo;
    }

    @Override
    public String getSupportedType() {
        return "github";
    }
}
