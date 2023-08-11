package com.zjq.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjq.springboot.entity.Task;
import com.zjq.springboot.mapper.TaskMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends ServiceImpl<TaskMapper, Task> {

    public boolean saveTask(Task task){
        return saveOrUpdate(task);
    }

}
