package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */
public enum ReportStatusEnum {
    // 未处理
    NOT_HANDLED(0),
    // 已处理
    HANDLED(1);

    private final int status;

    public int getStatus(){
        return status;
    }
    ReportStatusEnum(int status){
        this.status = status;
    }

}
