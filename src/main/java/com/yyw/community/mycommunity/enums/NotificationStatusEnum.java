package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/7/20
 */
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
