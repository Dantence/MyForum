package com.yyw.community.mycommunity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/19
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
