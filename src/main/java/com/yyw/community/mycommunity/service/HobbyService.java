package com.yyw.community.mycommunity.service;/**
 * @author Dantence
 * @description:
 * @date 2022/11/9
 */

import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.mapper.HobbyCacheMapper;
import com.yyw.community.mycommunity.mapper.UserHobbyExtMapper;
import com.yyw.community.mycommunity.mapper.UserHobbyMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.service
 * @className: HobbyService
 * @author: Dantence
 * @description: 爱好服务类
 * @date: 2022/11/9 0:23
 * @version: 1.0
 */
@Service
public class HobbyService {
    @Autowired
    private HobbyCacheMapper hobbyCacheMapper;

    @Autowired
    private UserHobbyMapper userHobbyMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserHobbyExtMapper userHobbyExtMapper;

    public List<String> getHobbyNames() {
        return hobbyCacheMapper.selectByExample(null)
                .stream()
                .map(HobbyCache::getHobbyName)
                .collect(Collectors.toList());
    }

    public String getHobbiesByUserId(Long userId) {
        UserHobbyExample userHobbyExample = new UserHobbyExample();
        userHobbyExample.createCriteria().andUserIdEqualTo(userId);
        List<String> hobbyNames = userHobbyMapper.selectByExample(userHobbyExample)
                .stream()
                .map(o -> hobbyCacheMapper.selectByPrimaryKey(o.getHobbyId()).getHobbyName())
                .collect(Collectors.toList());
        return String.join(",", hobbyNames);
    }

    public List<String> getHobbyNamesByUserId(Long userId) {
        UserHobbyExample userHobbyExample = new UserHobbyExample();
        userHobbyExample.createCriteria().andUserIdEqualTo(userId);
        return userHobbyMapper.selectByExample(userHobbyExample)
                .stream()
                .map(o -> hobbyCacheMapper.selectByPrimaryKey(o.getId()).getHobbyName())
                .collect(Collectors.toList());
    }

    public void deleteHobbiesByUserId(Long userId){
        UserHobbyExample userHobbyExample = new UserHobbyExample();
        userHobbyExample.createCriteria().andUserIdEqualTo(userId);
        userHobbyMapper.deleteByExample(userHobbyExample);
    }

    public Long getHobbyIdByHobbyName(String hobbyName){
        HobbyCacheExample hobbyCacheExample = new HobbyCacheExample();
        hobbyCacheExample.createCriteria().andHobbyNameEqualTo(hobbyName);
        List<HobbyCache> hobbyCacheList = hobbyCacheMapper.selectByExample(hobbyCacheExample);
        if(hobbyCacheList.isEmpty()){
            return 0L;
        }
        return hobbyCacheList.get(0).getId();
    }

    public int insertUserHobby(UserHobby userHobby){
        return userHobbyMapper.insert(userHobby);
    }

    public List<User> getInterestedUsers(Long userId){
        return userHobbyExtMapper.selectSameHobbyUser(userId);
    }

}
