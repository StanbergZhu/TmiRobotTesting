package com.zjq.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjq.springboot.entity.ExecuteTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExecuteTaskMapper extends BaseMapper<ExecuteTask> {

    @Select("SELECT * FROM `task_execute`")
    List<ExecuteTask> findAll();

    @Select("SELECT * FROM `task_execute` WHERE execute_plan_id=#{id}")
    List<ExecuteTask> findByExecutePlanId(Long id);

    @Select("SELECT execute_plan_id FROM `task_execute` WHERE id=#{id}")
    Long getExecutePlanId(Long id);

    @Update("UPDATE `task_execute` SET end_time=#{endTime}, status=#{status} WHERE id=#{id}")
    void finishTask(Date endTime, Long id, String status);

    @Select("SELECT COUNT(*) FROM `task_execute` WHERE execute_plan_id = " +
            "(SELECT execute_plan_Id FROM `task_execute` WHERE id=#{id}) AND status='PROCESSING';")
    int undoTasksInPlan(Long id);
}
