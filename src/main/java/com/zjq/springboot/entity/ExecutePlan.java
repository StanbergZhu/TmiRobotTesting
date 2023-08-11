package com.zjq.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@TableName(value = "plan_execute")
@Data
public class ExecutePlan {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long planId;
    private String status;
    private Integer executeTasks;
    private Integer successTasks;
    private Integer failTasks;
    private Date startTime;
    private Integer timeCost;
    private String executor;

    public ExecutePlan(Long planId,
                       Integer executeTasks,
                       String executor) {
        this.planId = planId;
        this.status = "PROCESSING";
        this.executeTasks = executeTasks;
        this.successTasks = 0;
        this.failTasks = 0;
        this.startTime = new Date();
        this.executor = executor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExecuteTasks() {
        return executeTasks;
    }

    public void setExecuteTasks(Integer executeTasks) {
        this.executeTasks = executeTasks;
    }

    public Integer getSuccessTasks() {
        return successTasks;
    }

    public void setSuccessTasks(Integer successTasks) {
        this.successTasks = successTasks;
    }

    public Integer getFailTasks() {
        return failTasks;
    }

    public void setFailTasks(Integer failTasks) {
        this.failTasks = failTasks;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Integer getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Integer timeCost) {
        this.timeCost = timeCost;
    }
}
