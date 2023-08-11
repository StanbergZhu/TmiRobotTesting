package com.zjq.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjq.springboot.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {

    @Select("SELECT * FROM `task_data`")
    List<Task> findAll();

    @Select("SELECT * FROM `task_data` WHERE plan_id=#{id} ORDER BY rank")
    List<Task> findByPlanId(Long id);

}
