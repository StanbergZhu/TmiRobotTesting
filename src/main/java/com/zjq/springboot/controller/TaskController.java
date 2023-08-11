package com.zjq.springboot.controller;

import com.zjq.springboot.config.WebConfig;
import com.zjq.springboot.entity.ExecuteTask;
import com.zjq.springboot.entity.ResReport;
import com.zjq.springboot.entity.Task;
import com.zjq.springboot.mapper.ExecutePlanMapper;
import com.zjq.springboot.mapper.ExecuteTaskMapper;
import com.zjq.springboot.mapper.TaskMapper;
import com.zjq.springboot.service.TaskService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final ExecuteTaskMapper executeTaskMapper;
    private final ExecutePlanMapper executePlanMapper;

    private final PlanController planController;

    public TaskController(
            TaskService taskService,
            TaskMapper taskMapper,
            ExecuteTaskMapper executeTaskMapper,
            ExecutePlanMapper executePlanMapper, PlanController planController) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.executeTaskMapper = executeTaskMapper;
        this.executePlanMapper = executePlanMapper;
        this.planController = planController;
    }

    @GetMapping("/info")
    public List<ExecuteTask> index(){
        return executeTaskMapper.findAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PostMapping("/delete")
    public boolean delete(Long taskId){
        return taskMapper.deleteById(taskId) == 1;
    }

    @PostMapping("/upload")
    public boolean upload(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PostMapping("/getById")
    public Task getTask(Long taskId){
        return taskMapper.selectById(taskId);
    }

    @PostMapping("/startPlan")//for test
    public boolean test(String executedPlanId){
        System.out.println(Long.valueOf(executedPlanId));
        List<ExecuteTask> tasks = executeTaskMapper.findByExecutePlanId(Long.valueOf(executedPlanId));
        for (int i=0; i<1; i++){
            if (tasks == null || !sendTask(tasks.get(i))){
                System.out.println("POST request failed: task " + i);
                return false;
            }
        }
        return true;
    }

    @PostMapping("/getExecutedTasks")
    public List<ExecuteTask> getExeTasks(Long executedPlanId){
        return executeTaskMapper.findByExecutePlanId(executedPlanId);
    }

    @PostMapping("/sendRes")
    public boolean getTaskRes(@RequestBody ResReport resReport){
        System.out.println("RES: "+resReport.getTaskId()+" "+resReport.getStatus());
        Long id = resReport.getTaskId();
        if (resReport.getStatus()){
            executeTaskMapper.finishTask(new Date(), id, "SUCCESS");
            executePlanMapper.taskSuccess(executeTaskMapper.getExecutePlanId(id));
        }else {
            executeTaskMapper.finishTask(new Date(), id, "FAILURE");
            executePlanMapper.taskFail(executeTaskMapper.getExecutePlanId(id));
        }

        if (executeTaskMapper.undoTasksInPlan(id) == 0){
            planController.finishExecutePlan(executeTaskMapper.getExecutePlanId(id));
        }
        return true;
    }

    private boolean sendTask(ExecuteTask task){
        try {
            // 目标服务器URL
            URL url = new URL("http://"+ WebConfig.mockerIP +":9091/api/task_get");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置请求方法为POST
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            // 开启输出流
            conn.setDoOutput(true);
            // 创建JSON对象
            JSONObject json = new JSONObject();
            // 添加键值对
            json.put("task_id", task.getId());
            json.put("task_status", task.getStatus());
            json.put("task_type", task.getTaskType());

            // 获取输出流对象
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            // 发送请求参数
            wr.writeBytes(json.toString());
            wr.flush();
            wr.close();
            // 获取响应状态码
            int responseCode = conn.getResponseCode();
            // 打印响应结果
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // 输出响应结果
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response : " + response);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
