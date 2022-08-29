package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.MessageDTO;
import com.yyw.community.mycommunity.dto.MessageNewDTO;
import com.yyw.community.mycommunity.dto.NotificationDTO;
import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.enums.MessageStatusEnum;
import com.yyw.community.mycommunity.enums.NotificationTypeEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.MessageExtMapper;
import com.yyw.community.mycommunity.mapper.MessageMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/22
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageExtMapper messageExtMapper;

    @Autowired
    private UserMapper userMapper;

    public List<MessageDTO> selectMessages(Long id1, Long id2) {
        List<Message> messages = messageExtMapper.selectMessages(id1, id2);
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message message : messages) {
            User user = userMapper.selectByPrimaryKey(message.getCreator());
            if (user == null) {
                throw new CustomizeException(CustomizeErrorCodeImpl.MESSAGE_ERROR);
            }
            MessageDTO messageDTO = new MessageDTO();
            BeanUtils.copyProperties(message, messageDTO);
            messageDTO.setUser(user);
            messageDTOS.add(messageDTO);
        }
        return messageDTOS;
    }

    public Long unreadCount(Long id) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andReceiverEqualTo(id).andStatusEqualTo(MessageStatusEnum.UNREAD.getStatus());
        return messageMapper.countByExample(messageExample);
    }

    public PaginationDTO<MessageNewDTO> list(Long userId, Integer page, Integer size) {

        Integer offset = size * (page - 1);
        MessageExample example = new MessageExample();
        example.createCriteria().andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        Integer totalCount = (int) messageMapper.countByExample(example);
        List<Message> messages = messageMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<MessageNewDTO> MessageNewDTOs = new ArrayList<>();
        PaginationDTO<MessageNewDTO> paginationDTO = new PaginationDTO<>();
        paginationDTO.setPagination(totalCount, page, size);

        if (messages.size() == 0) {
            return paginationDTO;
        }
        for (Message message : messages) {
            MessageNewDTO messageNewDTO = new MessageNewDTO();
            messageNewDTO.setAction("回复了你");
            messageNewDTO.setCreatorId(message.getCreator());
            messageNewDTO.setId(message.getId());
            User creator = userMapper.selectByPrimaryKey(message.getCreator());
            if(creator == null){
                throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_FOUND);
            }
            messageNewDTO.setCreatorName(creator.getName());
            messageNewDTO.setStatus(message.getStatus());
            MessageNewDTOs.add(messageNewDTO);
        }
        paginationDTO.setData(MessageNewDTOs);
        return paginationDTO;
    }

    public void read(Long messageId) {
        Message message = new Message();
        message.setId(messageId);
        message.setStatus(MessageStatusEnum.READ.getStatus());
        messageMapper.updateByPrimaryKeySelective(message);
    }
}
