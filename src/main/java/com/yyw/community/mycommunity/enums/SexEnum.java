package com.yyw.community.mycommunity.enums;

import lombok.Data;

/**
 * @author Dantence
 * @description: 性别枚举类
 * @date 2022/11/9
 */

public enum SexEnum {
    //男
    MALE(1, "男"),
    //女
    FEMALE(0, "女"),
    //保密
    SECRET(2, "保密")
    ;
    private final Integer sex;
    private final String name;

    public String getName(){
        return this.name;
    }

    public Integer getSex(){
        return this.sex;
    }

    SexEnum(Integer sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public static SexEnum getSexEnumBySex(Integer sex){
        for(SexEnum sexEnum : values()){
            if(sexEnum.getSex().equals(sex)){
                return sexEnum;
            }
        }
        return null;
    }

    public static String getNameBySex(Integer sex){
        SexEnum sexEnum = getSexEnumBySex(sex);
        if(sexEnum != null){
            switch (sexEnum){
                case MALE: return MALE.name;
                case FEMALE: return FEMALE.name;
                case SECRET: return SECRET.name;
                default: return null;
            }
        }
        return null;
    }
}
