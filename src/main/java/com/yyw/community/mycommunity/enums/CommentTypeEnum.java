package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/7/12
 */
public enum CommentTypeEnum {
    POST(1),
    COMMENT(2);
    private final Integer type;
    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
