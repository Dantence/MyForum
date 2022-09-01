package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.service.FavorService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dantence
 * @date 2022/8/31
 */
@Controller
public class FavorController {
    @Autowired
    private FavorService favorService;

    @GetMapping("/favor/{id}")
    public String doFavor(@PathVariable(name = "id") Long id,
                        HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        Integer isFavored = favorService.isFavored(user.getId(), id);
        int rows;
        if(isFavored == 0){
            rows = favorService.favor(user.getId(), id);
        } else {
            rows = favorService.unFavor(user.getId(), id);
        }
        if(rows != 1){
            throw new CustomizeException(CustomizeErrorCodeImpl.SYSTEM_ERROR);
        }
        return "redirect:/post/" + id;
    }

    @GetMapping("/unfavor/{id}")
    public String unFavor(@PathVariable(name = "id") Long id,
                          HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        int rows = favorService.unFavor(user.getId(), id);
        if(rows != 1){
            throw new CustomizeException(CustomizeErrorCodeImpl.SYSTEM_ERROR);
        }
        return "redirect:/mine/favor";
    }
}
