create table plan_data
(
    id           bigint(10) auto_increment comment '测试计划ID'
        primary key,
    plan_name    varchar(50) null comment '计划名',
    loop_num     int         null comment '循环次数',
    iteration    varchar(20) null comment '迭代',
    version      varchar(20) null comment '版本',
    robot_server varchar(50) null comment '机器人服务器',
    tester_num   int         null comment '测试人数',
    created_time timestamp   null comment '创建时间',
    update_time  timestamp   null on update CURRENT_TIMESTAMP comment '更新时间'
);

INSERT INTO backendlearning.plan_data (id, plan_name, loop_num, iteration, version, robot_server, tester_num, created_time, update_time) VALUES (1, '测试计划1', 1, '项目测试', '第一版', '默认', 1, '2023-07-18 14:52:46', '2023-07-18 14:53:17');
INSERT INTO backendlearning.plan_data (id, plan_name, loop_num, iteration, version, robot_server, tester_num, created_time, update_time) VALUES (2, '测试计划2', 1, '业务测试', '第二版', '默认', 1, '2023-07-24 15:43:26', '2023-07-24 15:43:30');
INSERT INTO backendlearning.plan_data (id, plan_name, loop_num, iteration, version, robot_server, tester_num, created_time, update_time) VALUES (3, '测试计划3', 2, '项目前瞻', '第三版', '默认', 2, '2023-07-24 09:05:46', '2023-07-24 09:05:58');
