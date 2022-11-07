package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */
public enum CarouselStatusEnum {
    // 已下架
    EXPIRED(0),
    // 正在使用
    IN_USE(1);

    private final int status;

    public int getStatus(){
        return status;
    }
    CarouselStatusEnum(int status){
        this.status = status;
    }
}
