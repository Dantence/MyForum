package com.yyw.community.mycommunity.controller;/**
 * @author Dantence
 * @description:
 * @date 2022/11/8
 */

import com.yyw.community.mycommunity.entity.*;
import com.yyw.community.mycommunity.enums.SexEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.UserInfoMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.HobbyService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.controller
 * @className: UserInfoController
 * @author: Dantence
 * @description: 用户信息控制类
 * @date: 2022/11/8 23:29
 * @version: 1.0
 */
@Controller
public class UserInfoController {

    static final int maxLength = 100;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private HobbyService hobbyService;

    @PostMapping("/submitUserInfo")
    @Transactional
    public String submitUserInfo(@RequestParam(name = "nickname", required = false) String nickname,
                                 @RequestParam(name = "birthday", required = false) String birthday,
                                 @RequestParam(name = "sex", required = false) String sex,
                                 @RequestParam(name = "city", required = false) String city,
                                 @RequestParam(name = "blog", required = false) String blog,
                                 @RequestParam(name = "introduction", required = false) String introduction,
                                 @RequestParam(name = "school", required = false) String school,
                                 @RequestParam(name = "major", required = false) String major,
                                 @RequestParam(name = "college", required = false) String college,
                                 @RequestParam(name = "classroom", required = false) String classroom,
                                 @RequestParam(name = "company", required = false) String company,
                                 @RequestParam(name = "bio", required = false) String bio,
                                 @RequestParam(name = "hobby", required = false) String hobby,
                                 @RequestParam(name = "job", required = false) String job,
                                 HttpServletRequest request) {
        User user = commonUtils.getUserFromSession(request);
        if (user == null || user.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        if (nickname != null && nickname.length() > maxLength || birthday != null && birthday.length() > maxLength || sex != null && sex.length() > maxLength
                || city != null && city.length() > maxLength || blog != null && blog.length() > maxLength * 10 || introduction != null && introduction.length() > maxLength * 20
                || school != null && school.length() > maxLength || major != null && major.length() > maxLength || college != null && college.length() > maxLength
                || classroom != null && classroom.length() > maxLength || company != null && company.length() > maxLength || bio != null && bio.length() > maxLength * 5
                || job != null && job.length() > maxLength || hobby != null && hobby.length() > maxLength * 3) {
            throw new CustomizeException(CustomizeErrorCodeImpl.INPUT_TOO_LONG);
        }
        Long now = System.currentTimeMillis();
        User updateUser = new User();
        updateUser.setBio(bio);
        updateUser.setGmtModified(now);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        userMapper.updateByExampleSelective(updateUser, userExample);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setNickname(nickname);
        userInfo.setBirthday(birthday);
        if (sex != null) {
            userInfo.setSex(SexEnum.getNameBySex(Integer.valueOf(sex)));
        }
        userInfo.setCity(city);
        userInfo.setBlog(blog);
        userInfo.setIntroduction(introduction);
        userInfo.setSchool(school);
        userInfo.setMajor(major);
        userInfo.setCollege(college);
        userInfo.setClassroom(classroom);
        userInfo.setCompany(company);
        userInfo.setJob(job);
        userInfo.setGmtModified(now);

        UserInfoExample userInfoSelectExample = new UserInfoExample();
        userInfoSelectExample.createCriteria().andUserIdEqualTo(user.getId());
        List<UserInfo> oldUserInfos = userInfoMapper.selectByExample(userInfoSelectExample);
        if (oldUserInfos.isEmpty()) {
            userInfo.setGmtCreate(now);
            userInfoMapper.insert(userInfo);
        } else {
            userInfo.setId(oldUserInfos.get(0).getId());
            userInfoMapper.updateByExample(userInfo, userInfoSelectExample);
        }
        hobbyService.deleteHobbiesByUserId(user.getId());

        String[] hobbyNames = hobby.split(",");
        for (String hobbyName : hobbyNames) {
            Long hobbyId = hobbyService.getHobbyIdByHobbyName(hobbyName);
            if (hobbyId.equals(0L)) {
                throw new CustomizeException(CustomizeErrorCodeImpl.UNACCEPTABLE_HOBBY);
            }
            UserHobby userHobby = new UserHobby();
            userHobby.setUserId(user.getId());
            userHobby.setHobbyId(hobbyId);
            userHobby.setGmtCreate(now);
            userHobby.setGmtModified(now);
            int rows = hobbyService.insertUserHobby(userHobby);
            if (rows != 1) {
                throw new CustomizeException(CustomizeErrorCodeImpl.SYSTEM_ERROR);
            }
        }
        return "redirect:/profile/" + user.getId();
    }
}
