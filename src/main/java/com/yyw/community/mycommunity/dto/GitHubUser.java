package com.yyw.community.mycommunity.dto;

import lombok.Data;
/**
 * @author Dantence
 * @date 2022/7/6
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
