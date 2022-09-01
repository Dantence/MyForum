package com.yyw.community.mycommunity.exception;

/**
 * @author Dantence
 * @date 2022/7/11 封装异常信息
 */
public enum CustomizeErrorCodeImpl implements CustomizeErrorCode {
    POST_NOT_FOUND(2001, "您找的帖子不在了，要不换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何帖子或评论进行回复"),
    USER_NOT_LOGIN(2003, "当前操作需要登录，请登录后重试"),
    USER_NOT_FOUND(2004,"用户不存在!"),
    SYSTEM_ERROR(2005,"服务器冒烟了..."),
    TYPE_PARAM_ERROR(2006, "评论类型错误或不存在!"),
    COMMENT_NOT_FOUND(2007, "回复的评论不存在!"),
    CONTENT_EMPTY(2008,"输入内容不能为空!"),
    NOTIFICATION_ERROR(2009, "消息非法访问!"),
    NOTIFICATION_NOT_FOUND(2010, "消息不存在!"),
    MESSAGE_ERROR(2011,"信息错误"),
    DUPLICATED_LIKE(2012,"不能重复点赞!")


    ;
    private final String message;
    private final Integer code;
    @Override
    public String getMessage(){
        return message;
    }
    @Override
    public Integer getCode(){
        return code;
    }
    CustomizeErrorCodeImpl(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
