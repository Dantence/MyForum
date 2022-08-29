package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.entity.UserExample;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Dantence
 * @date 2022/7/7
 */
@Controller
public class LogoutController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 退出登录，删除cookie和session，数据库查出用户打上标记
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0){
            return "redirect:/";
        }
        User findedUser = userMapper.selectByPrimaryKey(user.getId());
        if(findedUser == null){
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_FOUND);
        } else {
            request.getSession().removeAttribute("user");
            Cookie cookie = new Cookie("token", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            User updateUser = new User();
            updateUser.setIsValid(0);
            updateUser.setId(user.getId());
            userMapper.updateByPrimaryKeySelective(updateUser);
        }
        return "redirect:/";
    }

}
