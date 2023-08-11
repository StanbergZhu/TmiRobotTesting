package com.zjq.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjq.springboot.entity.ExecuteTask;
import com.zjq.springboot.mapper.ExecuteTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class ExecuteTaskService extends ServiceImpl<ExecuteTaskMapper, ExecuteTask> {

    public boolean saveTask(ExecuteTask executeTask){
        return saveOrUpdate(executeTask);
    }

}
