package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.NotificationDTO;
import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.enums.NotificationStatusEnum;
import com.yyw.community.mycommunity.enums.NotificationTypeEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCode;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.NotificationMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dantence
 * @date 2022/7/20
 */
@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO<NotificationDTO> list(Long userId, Integer page, Integer size) {
        Integer offset = size * (page - 1);
        NotificationExample example = new NotificationExample();
        example.createCriteria().andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        Integer totalCount = (int) notificationMapper.countByExample(example);
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        PaginationDTO <NotificationDTO> paginationDTO = new PaginationDTO<>();
        paginationDTO.setPagination(totalCount, page, size);

        if(notifications.size() == 0) {
            return paginationDTO;
        }
        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOList.add(notificationDTO);
        }
        paginationDTO.setData(notificationDTOList);
        return paginationDTO;
    }

    public Long unreadCount(Long id) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(id).andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if(notification == null){
            throw new CustomizeException(CustomizeErrorCodeImpl.NOTIFICATION_NOT_FOUND);
        }
        if(!notification.getReceiver().equals(user.getId())) {
            throw new CustomizeException(CustomizeErrorCodeImpl.NOTIFICATION_ERROR);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);
        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }
}
