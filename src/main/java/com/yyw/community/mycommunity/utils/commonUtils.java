package com.yyw.community.mycommunity.utils;

import com.yyw.community.mycommunity.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
/**
 * @author Dantence
 * @date 2022/7/6
 */

public class commonUtils {
    /**
     * 获取cookie中的token字段
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static User getUserFromSession(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }
}
