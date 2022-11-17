package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.cache.HotTagCache;
import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.entity.Carousel;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.CarouselService;
import com.yyw.community.mycommunity.service.HobbyService;
import com.yyw.community.mycommunity.service.PostService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/6
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostService postService;

    @Autowired
    private HotTagCache hotTagCache;

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private HobbyService hobbyService;

    /**
     * 访问首页，获取帖子列表
     * @param model
     * @param page  当前页码数，默认为第一页
     * @param size  每页展示的帖子数量
     * @param search 搜索关键词
     * @return
     */
    @GetMapping("/")
    public String Index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "10") Integer size,
                        @RequestParam(name = "search", required = false) String search,
                        @RequestParam(name = "tag", required = false) String tag,
                        HttpServletRequest request
    ){
        PaginationDTO<PostDTO> pagination = postService.list(search, tag, page, size);
        List<String> hotTags = hotTagCache.getHots();
        List<Carousel> carousels = carouselService.list();
        User user = commonUtils.getUserFromSession(request);
        if(user != null) {
            List<User> interestedUsers = hobbyService.getInterestedUsers(user.getId());
            model.addAttribute("interestedUsers", interestedUsers);
        }
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("hotTags", hotTags);
        model.addAttribute("tag", tag);
        model.addAttribute("carousels", carousels);
        return "index";
    }
}
