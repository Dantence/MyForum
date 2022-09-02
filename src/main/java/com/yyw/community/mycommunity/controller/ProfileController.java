package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.ProfileDTO;
import com.yyw.community.mycommunity.dto.ResultDTO;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.FollowFanExtMapper;
import com.yyw.community.mycommunity.mapper.FollowFanMapper;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.FollowFanService;
import com.yyw.community.mycommunity.service.PostService;
import com.yyw.community.mycommunity.service.UserService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dantence
 * @date 2022/7/21
 */
@Controller
public class ProfileController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FollowFanService followFanService;

    @GetMapping("/profile/{id}")
    public String showPost(@PathVariable(name = "id") Long id,
                           HttpServletRequest request,
                           Model model){
        User loginUser = commonUtils.getUserFromSession(request);
        if (loginUser == null || loginUser.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }

        User user = userMapper.selectByPrimaryKey(id);
        if(user == null || user.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_FOUND);
        }
        Long postCount = postService.postCount(id);
        Integer fanCount = followFanService.getFanCount(id);
        Integer followCount = followFanService.getFollowCount(id);
        Integer isFollowed = followFanService.isFollowed(loginUser.getId(), user.getId());

        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setPostCount(postCount);
        profileDTO.setUser(user);
        profileDTO.setFanCount(Long.valueOf(fanCount));
        profileDTO.setFollowCount(Long.valueOf(followCount));
        model.addAttribute("profile", profileDTO);
        model.addAttribute("isFollowed", isFollowed);
        model.addAttribute("floorExp", commonUtils.getExpFloor(user.getLevel()));
        return "profile";
    }
}
