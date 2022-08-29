package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.PaginationDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search", required = false) String search){

        PaginationDTO<PostDTO> pagination = postService.list(search, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        return "index";
    }
}
