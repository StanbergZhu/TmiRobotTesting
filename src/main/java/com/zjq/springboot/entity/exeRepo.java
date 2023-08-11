package com.zjq.springboot.entity;

import lombok.Data;

@Data
public class exeRepo {
    private String id;

    public exeRepo(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
