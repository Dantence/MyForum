package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.entity.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/21
 */
@Data
public class ProfileDTO {
    private User user;
    //用户关注的人数
    private Long followCount;
    //关注用户的人数
    private Long fanCount;
    //用户发布的帖子数
    private Long postCount;
    //用户详细信息
    private UserInfo userInfo;
    //用户爱好
    private String hobby;
}
