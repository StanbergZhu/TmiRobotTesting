package com.zjq.springboot.entity;

import lombok.Data;

@Data
public class LoginData {
    private boolean isExist;
    private String name;

    public LoginData(boolean isExist, String name) {
        this.isExist = isExist;
        this.name = name;
    }
}
