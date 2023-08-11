package com.zjq.springboot.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

import java.util.Arrays;
import java.util.List;

public enum RoleEnum implements BaseEnum{

    Admin(0, "管理员"),
    Member(1, "成员");

    @EnumValue
    private final int code;
    private final String message;
    public static final List<RoleEnum> availableStatus = Arrays.asList(RoleEnum.Admin, RoleEnum.Member);

    RoleEnum(int code, String name) {
        this.code = code;
        this.message = name;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
