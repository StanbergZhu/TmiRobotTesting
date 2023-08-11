package com.zjq.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@TableName(value = "plan_data")
@Data
public class Plan {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String planName;
    private Integer loopNum;
    private String iteration;
    private String version;
    private String robotServer;
    private Integer testerNum;
    private Date createdTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getLoopNum() {
        return loopNum;
    }

    public void setLoopNum(Integer loopNum) {
        this.loopNum = loopNum;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRobotServer() {
        return robotServer;
    }

    public void setRobotServer(String robotServer) {
        this.robotServer = robotServer;
    }

    public Integer getTesterNum() {
        return testerNum;
    }

    public void setTesterNum(Integer testerNum) {
        this.testerNum = testerNum;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
