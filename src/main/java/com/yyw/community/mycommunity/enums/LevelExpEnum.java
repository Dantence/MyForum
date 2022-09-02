package com.yyw.community.mycommunity.enums;

/**
 * @author Dantence
 * @date 2022/9/2
 */
public enum LevelExpEnum {
    LEVEL2(100),
    LEVEL3(300),
    LEVEL4(600),
    LEVEL5(1000),
    LEVEL6(2000)
    ;
    private final Integer exp;
    LevelExpEnum(Integer exp){this.exp = exp; }
    public Integer getLevel(){
        return this.exp;
    }
}
