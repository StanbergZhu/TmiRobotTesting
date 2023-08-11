package com.zjq.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjq.springboot.entity.Plan;
import com.zjq.springboot.mapper.PlanMapper;
import org.springframework.stereotype.Service;

@Service
public class PlanService extends ServiceImpl<PlanMapper, Plan> {

    public boolean savePlan(Plan plan){
        return saveOrUpdate(plan);
    }

}
