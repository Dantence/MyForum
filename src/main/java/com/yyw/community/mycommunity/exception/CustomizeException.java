package com.yyw.community.mycommunity.exception;

/**
 * @author Dantence
 * @date 2022/7/11
 */
public class CustomizeException extends RuntimeException {
    private final String message;
    private final Integer code;
    public CustomizeException(CustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode(){
        return code;
    }
}
