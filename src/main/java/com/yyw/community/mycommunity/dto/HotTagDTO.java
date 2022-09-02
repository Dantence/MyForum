package com.yyw.community.mycommunity.dto;

import lombok.Data;

/**
 * @author Dantence
 * @date 2022/9/1
 */
@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Long value;

    @Override
    public int compareTo(Object o) {
        return (int) (this.getValue() - ((HotTagDTO) o ).getValue());
    }
}
