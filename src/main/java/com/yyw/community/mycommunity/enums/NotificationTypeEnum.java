package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/7/20
 */
public enum NotificationTypeEnum {
    REPLY_POST(1,"回复了帖子"),
    REPLY_COMMENT(2,"回复了评论");

    private int type;
    private String name;

    public int getType(){
        return type;
    }

    public String getName(){
        return name;
    }
    NotificationTypeEnum(int status, String name) {
        this.type = status;
        this.name = name;
    }

    public static String nameOfType(int type){
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if(notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
