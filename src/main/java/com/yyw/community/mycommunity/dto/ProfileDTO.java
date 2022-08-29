package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.User;
import lombok.Data;

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
}
