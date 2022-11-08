package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.entity.UserExample;
import com.yyw.community.mycommunity.mapper.PostMapper;
import com.yyw.community.mycommunity.mapper.UserExtMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserExtMapper userExtMapper;

    public void handleGithubUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId())
                .andTypeEqualTo(user.getType());
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
            updateUser.setLevel(user.getLevel());
            updateUser.setExp(user.getExp());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(findedUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        } else {
            user.setExp(0);
            user.setLevel(1);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }

    @Transactional
    public void updateLevel(Integer addExp, Long userId){
        User user = new User();
        user.setId(userId);
        user.setExp(addExp);
        userExtMapper.increaseExp(user);
        user = userMapper.selectByPrimaryKey(userId);
        Integer oriLevel = user.getLevel();
        Integer nowLevel = commonUtils.getLevel(user.getExp());
        if(!nowLevel.equals(oriLevel)){
            user = new User();
            user.setLevel(nowLevel);
            user.setId(userId);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }
}
