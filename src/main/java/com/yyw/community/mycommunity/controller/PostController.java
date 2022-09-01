package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.CommentDTO;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.CommentTypeEnum;
import com.yyw.community.mycommunity.service.CommentService;
import com.yyw.community.mycommunity.service.FavorService;
import com.yyw.community.mycommunity.service.LikeService;
import com.yyw.community.mycommunity.service.PostService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/7
 *       2022/7/12 实现累加阅读数功能
 *       2022/7/13 实现展示回复功能
 */
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private FavorService favorService;

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable(name = "id") Long id,
                           HttpServletRequest request,
                           Model model){
        List<CommentDTO> comments = commentService.selectByTargetId(id, CommentTypeEnum.POST.getType());
        PostDTO postDTO = postService.selectById(id);
        List<PostDTO> relatedPosts = postService.selectRelated(postDTO);
        postService.increaseViewCount(id);
        User user = commonUtils.getUserFromSession(request);
        Integer isFavored;
        if(user == null || user.getIsValid() == 0){
            isFavored = 0;
        } else {
            isFavored = favorService.isFavored(user.getId(), id);
        }
        model.addAttribute("post", postDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedPosts", relatedPosts);
        model.addAttribute("isFavored", isFavored);
        return "post";
    }
}
