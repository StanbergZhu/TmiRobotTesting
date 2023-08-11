create table plan_execute
(
    id            bigint(10) auto_increment
        primary key,
    plan_id       bigint(10)  null,
    status        varchar(20) null,
    execute_tasks int(10)     null,
    success_tasks int(10)     null,
    fail_tasks    int(10)     null,
    start_time    timestamp   null,
    time_cost     int(10)     null comment '/min',
    executor      varchar(20) null
);

INSERT INTO backendlearning.plan_execute (id, plan_id, status, execute_tasks, success_tasks, fail_tasks, start_time, time_cost, executor) VALUES (1684107248812331009, 1, 'PROCESSING', 2, 0, 0, '2023-07-26 15:43:52', null, 'tester1');
