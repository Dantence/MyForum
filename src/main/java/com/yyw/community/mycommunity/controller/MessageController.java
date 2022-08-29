package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.MessageDTO;
import com.yyw.community.mycommunity.entity.Message;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.MessageStatusEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.MessageExtMapper;
import com.yyw.community.mycommunity.mapper.MessageMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.MessageService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/22 完成私信功能
 *       2022/7/24 完成私信通知功能
 */
@Controller
public class MessageController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/message/{userId}")
    public String showMessage(@PathVariable(name = "userId") Long id,
                              @RequestParam(name = "messageId", required = false)Long messageId,
                              HttpServletRequest request,
                              Model model){

        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0){
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        messageService.read(messageId);
        List<MessageDTO> messageDTOS = messageService.selectMessages(user.getId(), id);
        model.addAttribute("messages", messageDTOS);
        model.addAttribute("receiver", id);
        User receiver = userMapper.selectByPrimaryKey(id);
        model.addAttribute("receiverName", receiver.getName());
        return "message";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(
            @RequestParam(value = "receiver", required = false) Long receiver,
            @RequestParam(value = "content", required = false) String content,
            HttpServletRequest request
    ){
        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0){
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        Message message = new Message();
        message.setCreator(user.getId());
        message.setReceiver(receiver);
        message.setContent(content);
        message.setStatus(MessageStatusEnum.UNREAD.getStatus());
        message.setGmtCreate(System.currentTimeMillis());
        messageMapper.insert(message);
        return "redirect:/message/" + receiver;
    }

}
