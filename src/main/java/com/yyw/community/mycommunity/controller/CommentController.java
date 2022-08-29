package com.yyw.community.mycommunity.controller;

import com.mysql.jdbc.StringUtils;
import com.yyw.community.mycommunity.dto.CommentCreateDTO;
import com.yyw.community.mycommunity.dto.CommentDTO;
import com.yyw.community.mycommunity.dto.ResultDTO;
import com.yyw.community.mycommunity.entity.Comment;
import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.enums.CommentTypeEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.service.CommentService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/12
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object doComment(@RequestBody CommentCreateDTO commentDTO,
                            HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCodeImpl.USER_NOT_LOGIN);
        }
        if(commentDTO == null || StringUtils.isNullOrEmpty(commentDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCodeImpl.CONTENT_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setLikesCount(0L);
        comment.setCommentator(user.getId());
        commentService.insert(comment, user);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id")Long id) {
        List<CommentDTO> commentDTOS = commentService.selectByTargetId(id, CommentTypeEnum.COMMENT.getType());
        return ResultDTO.okOf(commentDTOS);
    }
}
