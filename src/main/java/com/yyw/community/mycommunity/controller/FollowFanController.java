package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.FollowFanDTO;
import com.yyw.community.mycommunity.dto.ResultDTO;
import com.yyw.community.mycommunity.entity.FollowFan;
import com.yyw.community.mycommunity.mapper.FollowFanMapper;
import com.yyw.community.mycommunity.service.FollowFanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/21 完成关注、取关功能
 */
@Controller
public class FollowFanController {
    @Autowired
    private FollowFanMapper followFanMapper;

    @Autowired
    private FollowFanService followFanService;

    @ResponseBody
    @PostMapping("/follow")
    public Object doFollow(HttpServletRequest request){
        Long followId = Long.valueOf(request.getParameter("followId"));
        Long fanId = Long.valueOf(request.getParameter("fanId"));
        FollowFan followFan = new FollowFan();
        followFan.setFollowId(followId);
        followFan.setFanId(fanId);
        Integer code = followFanService.insert(followFan);
        Integer fanCount = followFanService.getFanCount(fanId);
        return ResultDTO.codeOf(fanCount, code);
    }

    @ResponseBody
    @PostMapping("/unfollow")
    public Object unFollow(HttpServletRequest request){
        Long followId = Long.valueOf(request.getParameter("followId"));
        Long fanId = Long.valueOf(request.getParameter("fanId"));
        FollowFan followFan = new FollowFan();
        followFan.setFollowId(followId);
        followFan.setFanId(fanId);
        Integer code = followFanService.delete(followFan);
        Integer fanCount = followFanService.getFanCount(fanId);
        return ResultDTO.codeOf(fanCount, code);
    }

    @GetMapping("/showfollows/{id}")
    public String showFollows(@PathVariable(name = "id") Long followId, Model model){
        List<FollowFanDTO> followFanDTOS = followFanService.getFollows(followId);
        model.addAttribute("follows", followFanDTOS);
        return "showfollows";
    }

    @GetMapping("/showfans/{id}")
    public String showFans(@PathVariable(name = "id") Long fanId, Model model){
        List<FollowFanDTO> followFanDTOS = followFanService.getFans(fanId);
        model.addAttribute("fans", followFanDTOS);
        return "showfans";
    }
}
