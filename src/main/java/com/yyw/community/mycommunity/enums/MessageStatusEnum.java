package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/7/22
 */
public enum MessageStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    MessageStatusEnum(int status) {
        this.status = status;
    }
}
