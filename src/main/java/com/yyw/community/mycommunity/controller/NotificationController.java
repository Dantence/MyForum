package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.NotificationDTO;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.NotificationTypeEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.service.NotificationService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dantence
 * @date 2022/7/20 点击回复标题进入相应的帖子
 */
@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/notification/{id}")
    public String notification (@PathVariable(name = "id") Long id,
                                HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0){
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        NotificationDTO notificationDTO = notificationService.read(id, user);
        if(notificationDTO.getType() == NotificationTypeEnum.REPLY_COMMENT.getType() ||
            notificationDTO.getType() == NotificationTypeEnum.REPLY_POST.getType()){
            return "redirect:/post/" + notificationDTO.getOuterId();
        }
        return "redirect:/";
    }
}
