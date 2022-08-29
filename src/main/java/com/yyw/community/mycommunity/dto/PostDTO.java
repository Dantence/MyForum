package com.yyw.community.mycommunity.dto;

import com.yyw.community.mycommunity.entity.User;
import lombok.Data;

/**
 * @author Dantence
 * @date 2022/7/7
 */
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String tag;
    private Long publisher;
    private Long commentCount;
    private Long viewCount;
    private Long likesCount ;
    private Long gmtCreate;
    private Long gmtModified;
    private User user;
}
