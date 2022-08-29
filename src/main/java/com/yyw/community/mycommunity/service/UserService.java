package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.entity.UserExample;
import com.yyw.community.mycommunity.mapper.PostMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/8
 *       2022/7/10 使用mybatis-generator进行迁移，使用rowbounds模型进行分页
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void handleGithubUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List< User> findedUsers = userMapper.selectByExample(userExample);
        if(findedUsers.size() != 0){
            User findedUser = findedUsers.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setIsValid(user.getIsValid());
            updateUser.setBio(user.getBio());
            updateUser.setToken(user.getToken());
            updateUser.setName(user.getName());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(findedUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        } else {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }
}
