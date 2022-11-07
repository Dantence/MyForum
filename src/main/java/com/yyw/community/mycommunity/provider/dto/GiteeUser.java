package com.yyw.community.mycommunity.provider.dto;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import lombok.Data;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.provider.dto
 * @className: GiteeUser
 * @author: Dantence
 * @description: gitee用户
 * @date: 2022/11/7 20:38
 * @version: 1.0
 */
@Data
public class GiteeUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
