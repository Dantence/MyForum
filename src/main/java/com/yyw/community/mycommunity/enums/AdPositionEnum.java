package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @description: 广告位置枚举类
 * @date 2022/11/7
 */
public enum AdPositionEnum {

    //侧边栏
    SIDE(0),
    //页尾
    FOOTER(1),
    //页眉
    HEADER(2)
    ;
    private final Integer position;
    AdPositionEnum(Integer position){this.position = position; }
    public Integer getPosition(){
        return this.position;
    }
}