package com.zjq.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjq.springboot.entity.ExecutePlan;
import com.zjq.springboot.mapper.ExecutePlanMapper;
import org.springframework.stereotype.Service;

@Service
public class ExecutePlanService extends ServiceImpl<ExecutePlanMapper, ExecutePlan> {

    public boolean savePlan(ExecutePlan executePlan){
        return saveOrUpdate(executePlan);
    }

}
