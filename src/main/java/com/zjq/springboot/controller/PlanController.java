package com.zjq.springboot.controller;

import com.zjq.springboot.entity.*;
import com.zjq.springboot.mapper.ExecutePlanMapper;
import com.zjq.springboot.mapper.ExecuteTaskMapper;
import com.zjq.springboot.mapper.PlanMapper;
import com.zjq.springboot.mapper.TaskMapper;
import com.zjq.springboot.service.ExecutePlanService;
import com.zjq.springboot.service.ExecuteTaskService;
import com.zjq.springboot.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final PlanMapper planMapper;
    private final TaskMapper taskMapper;
    private final ExecuteTaskService executeTaskService;
    private final ExecuteTaskMapper executeTaskMapper;
    private final ExecutePlanService executePlanService;
    private final ExecutePlanMapper executePlanMapper;
    public PlanController(PlanMapper planMapper,
                          PlanService planService,
                          TaskMapper taskMapper,
                          ExecuteTaskService executeTaskService,
                          ExecutePlanService executePlanService,
                          ExecutePlanMapper executePlanMapper,
                          ExecuteTaskMapper executeTaskMapper) {
        this.planMapper = planMapper;
        this.planService = planService;
        this.taskMapper = taskMapper;
        this.executeTaskService = executeTaskService;
        this.executePlanService = executePlanService;
        this.executePlanMapper = executePlanMapper;
        this.executeTaskMapper = executeTaskMapper;
    }

    @GetMapping("/info")
    public List<Plan> index(){
        return planMapper.findAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody Plan plan){
        System.out.println(plan);
        plan.setCreatedTime(new Date());
        return planService.savePlan(plan);
    }

    @PostMapping("/delete")
    public boolean delete(Long planId){
        System.out.println(planId);
        return planMapper.deleteById(planId) == 1;
    }

    @PostMapping("/upload")
    public boolean upload(@RequestBody Plan plan) {
        System.out.println("——————————PLAN——————————"+plan);
        if (plan.getId() == null){
            return false;
        }else {
            return planService.savePlan(plan);
        }
    }

    @PostMapping("/getById")
    public Plan getPlan(Long planId){
        return planMapper.selectById(planId);
    }

    @PostMapping("/getTasksByPlanId")
    public List<Task> getTasks(Long planId){
        return taskMapper.findByPlanId(planId);
    }

    @PostMapping("/execute")
    public exeRepo executePlan(@RequestBody exeReq exe_req){
        List<Task> taskList = taskMapper.findByPlanId(exe_req.getPlanId());
        ExecutePlan executePlan = new ExecutePlan(
                exe_req.getPlanId(),
                exe_req.getTaskId().size(),
                exe_req.getExecutor());
        executePlanService.savePlan(executePlan);

        for (int i=0; i<taskList.size(); i++){
            if (!exe_req.getTaskId().contains(taskList.get(i).getId())){
                continue;
            }
            ExecuteTask executeTask = new ExecuteTask(
                    taskList.get(i).getId(),
                    taskList.get(i).getRank(),
                    taskList.get(i).getTaskType(),
                    executePlanMapper.getLatestPlanId());
            if (!executeTaskService.saveTask(executeTask)){
                System.out.println("POST request failed: task " + i);
                return null;
            }
        }
        return new exeRepo(executePlanMapper.getLatestPlanId().toString());
    }

    @PostMapping("/executedPlans")
    public List<ExecutePlan> getExecutedPlans(Long planId){
        return executePlanMapper.findByPlanId(planId);
    }

    @PostMapping("/finish")//计算计划执行耗时，单位：min
    public boolean finishExecutePlan(Long executedPlanId){
        System.out.println("------ID:"+executedPlanId);
        Date currentTime = new Date();
        Date startTime = executePlanMapper.findByExecuteId(executedPlanId).getStartTime();
        boolean success = true;

        List<ExecuteTask> taskList = executeTaskMapper.findByExecutePlanId(executedPlanId);
        for (ExecuteTask executeTask : taskList) {
            if (!executeTask.getStatus().equals("SUCCESS")) {
                success = false;
                executeTaskMapper.finishTask(currentTime, executeTask.getId(), "FAILURE");
                executePlanMapper.taskFail(executedPlanId);
            }
        }

        if (success){
            executePlanMapper.finishPlan(
                    (int) ((currentTime.getTime() - startTime.getTime()) / (1000 * 60)),
                    "SUCCESS",
                    executedPlanId
            );
        }else {
            executePlanMapper.finishPlan(
                    (int) ((currentTime.getTime() - startTime.getTime()) / (1000 * 60)),
                    "FAILURE",
                    executedPlanId
            );
        }
        return true;
    }
}
