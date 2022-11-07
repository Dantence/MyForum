package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */
public enum CarouselTypeEnum {
    //活动
    ACTIVITY(0),
    //竞赛
    CONTEST(1),
    //招聘
    RECRUIT(2),
    //其他
    OTHER(3);

    private int type;

    public int getType(){
        return type;
    }

    CarouselTypeEnum(int type) {
        this.type = type;
    }
}
