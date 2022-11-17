package com.yyw.community.mycommunity.mapper;/**
 * @author Dantence
 * @description:
 * @date 2022/11/9
 */

import com.yyw.community.mycommunity.entity.User;

import java.util.List;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.mapper
 * @className: UserHobbyExtMapper
 * @author: Dantence
 * @description:
 * @date: 2022/11/9 19:39
 * @version: 1.0
 */
public interface UserHobbyExtMapper {
    List<User> selectSameHobbyUser(Long userId);
}
