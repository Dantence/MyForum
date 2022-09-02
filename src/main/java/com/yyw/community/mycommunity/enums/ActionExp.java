package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/9/2
 */
public enum ActionExp {
    PUBLISH(5),
    COMMENT(1),
    FOLLOW(10)
    ;
    private final Integer exp;
    ActionExp(Integer exp){this.exp = exp; }
    public Integer getExp(){
        return this.exp;
    }
}
