package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.dto.AccessTokenDTO;
import com.yyw.community.mycommunity.provider.dto.GitHubUser;
import com.yyw.community.mycommunity.provider.GitHubProvider;
import com.yyw.community.mycommunity.service.UserService;
import com.yyw.community.mycommunity.strategy.LoginUserInfo;
import com.yyw.community.mycommunity.strategy.UserStrategy;
import com.yyw.community.mycommunity.strategy.UserStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Dantence
 * @date 2022/7/6
 */
@Controller
@Slf4j
public class AuthorizeController {
    @Autowired
    private UserStrategyFactory userStrategyFactory;

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    private UserService userService;

    /**
     * OAuth授权相关接口
     *
     * @param code
     * @param state
     * @param response
     * @return
     */
    @GetMapping("/callback/{type}")
    public String callback(@PathVariable(name = "type") String type,
                           @RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        UserStrategy userStratgety = userStrategyFactory.getStratgety(type);
        LoginUserInfo loginUserInfo = userStratgety.getUser(code, state);
        if (loginUserInfo != null && loginUserInfo.getId() != null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(loginUserInfo.getName());
            user.setAccountId(String.valueOf(loginUserInfo.getId()));
            user.setBio(loginUserInfo.getBio());
            user.setAvatarUrl(loginUserInfo.getAvatarUrl());
            user.setIsValid(1);
            userService.handleGithubUser(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            log.error("callback get github user error, {}", loginUserInfo);
            return "redirect:/";
        }
    }
}
