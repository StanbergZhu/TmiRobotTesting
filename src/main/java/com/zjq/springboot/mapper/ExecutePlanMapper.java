package com.zjq.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjq.springboot.entity.ExecutePlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ExecutePlanMapper extends BaseMapper<ExecutePlan> {

    @Select("SELECT * FROM `plan_execute`")
    List<ExecutePlan> findAll();

    @Select("SELECT * FROM `plan_execute` WHERE plan_id=#{id}")
    List<ExecutePlan> findByPlanId(Long id);

    @Select("SELECT * FROM `plan_execute` WHERE id=#{id}")
    ExecutePlan findByExecuteId(Long id);

    @Select("SELECT id FROM `plan_execute` ORDER BY start_time DESC LIMIT 1")
    Long getLatestPlanId();

    @Update("UPDATE `plan_execute` SET time_cost=#{timeCost}, status=#{status}WHERE id=#{id}")
    void finishPlan(int timeCost, String status, Long id);
    @Update("UPDATE `plan_execute` SET success_tasks=success_tasks+1 WHERE id=#{id}")
    void taskSuccess(Long id);
    @Update("UPDATE `plan_execute` SET fail_tasks=fail_tasks+1 WHERE id=#{id}")
    void taskFail(Long id);
}
