package com.yyw.community.mycommunity.utils;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.LevelExpEnum;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Dantence
 * @date 2022/7/6
 */

public class commonUtils {
    /**
     * 获取cookie中的token字段
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static User getUserFromSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }

    public static Integer getLevel(Integer exp) {
        if (exp < LevelExpEnum.LEVEL2.getLevel()) {
            return 1;
        } else if (exp < LevelExpEnum.LEVEL3.getLevel()) {
            return 2;
        } else if (exp < LevelExpEnum.LEVEL4.getLevel()) {
            return 3;
        } else if (exp < LevelExpEnum.LEVEL5.getLevel()) {
            return 4;
        } else if (exp < LevelExpEnum.LEVEL6.getLevel()) {
            return 5;
        } else {
            return 6;
        }
    }

    public static Integer getExpFloor(Integer level){
        Integer floor;
        switch (level) {
            case 1:
                floor = LevelExpEnum.LEVEL2.getLevel();
                break;
            case 2:
                floor = LevelExpEnum.LEVEL3.getLevel();
                break;
            case 3:
                floor = LevelExpEnum.LEVEL4.getLevel();
                break;
            case 4:
                floor = LevelExpEnum.LEVEL5.getLevel();
                break;
            case 5:
                floor = LevelExpEnum.LEVEL6.getLevel();
                break;
            default:
                floor = 9999;
                break;
        }
        return floor;
    }
}
