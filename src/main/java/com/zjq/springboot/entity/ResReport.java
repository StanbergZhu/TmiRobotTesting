package com.zjq.springboot.entity;

import lombok.Data;

@Data
public class ResReport {
    private Long task_id;
    private boolean task_status;//暂定

    public Long getTaskId() {
        return task_id;
    }

    public boolean getStatus() {
        return task_status;
    }
}
