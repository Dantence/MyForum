package com.yyw.community.mycommunity.controller;
import com.mysql.jdbc.StringUtils;
import com.yyw.community.mycommunity.cache.TagCache;
import com.yyw.community.mycommunity.dto.PostDTO;
import com.yyw.community.mycommunity.entity.Post;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.service.PostService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Dantence
 * @date 2022/7/6 发布新帖子功能实现
 *       2022/7/9 修改帖子功能实现
 *       2022/7/19 标签功能实现
 */
@Controller
public class PublishController {

    @Autowired
    private PostService postService;

    @GetMapping("/publish")
    public String publish(Model model){
        model.addAttribute("tags", TagCache.getTags());
        return "publish";
    }

    /**
     * 发布新帖子或修改帖子
     * @param title
     * @param content
     * @param tag
     * @param request
     * @param model
     * @return 重定向至首页
     */
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.getTags());

        User user = commonUtils.getUserFromSession(request);
        if(user == null || user.getIsValid() == 0) {
            throw new CustomizeException(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }

        if(StringUtils.isNullOrEmpty(title)){
            //标题为空
            model.addAttribute("error", "标题不能为空!");
            return "publish";
        }
        if(StringUtils.isNullOrEmpty(content)){
            //内容为空
            model.addAttribute("error", "内容不能为空!");
            return "publish";
        }
        if(StringUtils.isNullOrEmpty(tag)){
            //标签为空
            model.addAttribute("error", "标签不能为空!");
            return "publish";
        }
        String invalid = TagCache.filterInvalid(tag);
        if(!StringUtils.isNullOrEmpty(invalid)){
            //标签不合法
            model.addAttribute("error", "标签不合法!");
            return "publish";
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTag(tag);
        post.setPublisher(user.getId());
        post.setId(id);
        postService.handlePublish(post);
        return "redirect:/";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model){
        PostDTO post = postService.selectById(id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        model.addAttribute("tag", post.getTag());
        model.addAttribute("id", post.getId());
        model.addAttribute("tags", TagCache.getTags());
        return "publish";
    }
}
