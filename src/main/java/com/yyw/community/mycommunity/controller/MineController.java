package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.*;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.PostMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.MessageService;
import com.yyw.community.mycommunity.service.NotificationService;
import com.yyw.community.mycommunity.service.PostService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dantence
 * @date 2022/7/7
 *       2022/7/20 回复我的功能实现
 */
@Controller
public class MineController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PostService postService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/mine/{action}")
    public String mine(@PathVariable(name = "action")String action,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size,
                       Model model,
                       HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0){
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        if(action.equals("myposts")){
            PaginationDTO<PostDTO> paginationDTO = postService.list(user.getId(), page, size);
            model.addAttribute("section", "myposts");
            model.addAttribute("sectionName", "我发的帖");
            model.addAttribute("pagination", paginationDTO);
        } else if(action.equals("reply")) {
            PaginationDTO<NotificationDTO> paginationDTO = notificationService.list(user.getId(), page, size);
            model.addAttribute("section", "reply");
            model.addAttribute("sectionName", "我的通知");
            model.addAttribute("pagination", paginationDTO);
        } else if(action.equals("message")) {
            PaginationDTO<MessageNewDTO> paginationDTO = messageService.list(user.getId(), page, size);
            model.addAttribute("section", "message");
            model.addAttribute("sectionName", "我的私信");
            model.addAttribute("pagination", paginationDTO);
        }
        return "mine";
    }
}
