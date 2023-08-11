package com.zjq.springboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class exeReq {
    private Long planId;
    private String executor;
    private List<Long> taskId;

    public Long getPlanId() {
        return planId;
    }

    public String getExecutor() {
        return executor;
    }

    public List<Long> getTaskId() {
        return taskId;
    }
}
