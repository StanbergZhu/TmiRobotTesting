package com.zjq.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@TableName(value = "task_execute")
@Data
public class ExecuteTask {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long taskId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long executePlanId;
    private String status;
    private Integer rank;
    private String taskType;
    private Date startTime;
    private Date updateTime;

    public ExecuteTask(Long taskId, Integer rank, String taskType, Long executePlanId) {
        this.taskId = taskId;
        this.rank = rank;
        this.taskType = taskType;
        this.status = "PROCESSING";
        this.startTime = new Date();
        this.executePlanId = executePlanId;
    }

    public Long getExecutePlanId() {
        return executePlanId;
    }

    public void setExecutePlanId(Long executePlanId) {
        this.executePlanId = executePlanId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
