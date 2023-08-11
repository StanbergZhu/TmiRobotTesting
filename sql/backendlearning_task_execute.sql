create table task_execute
(
    id              bigint(10) auto_increment
        primary key,
    `rank`          int         null,
    execute_plan_id bigint(10)  null,
    task_id         bigint(10)  null,
    status          varchar(20) null,
    task_type       varchar(30) null,
    start_time      timestamp   null,
    end_time        timestamp   null
);

INSERT INTO backendlearning.task_execute (id, `rank`, execute_plan_id, task_id, status, task_type, start_time, end_time) VALUES (1684107248887828481, 3, 1684107248812331009, 2, 'PROCESSING', 'delivery', '2023-07-26 15:43:52', null);
INSERT INTO backendlearning.task_execute (id, `rank`, execute_plan_id, task_id, status, task_type, start_time, end_time) VALUES (1684107248912994306, 5, 1684107248812331009, 5, 'PROCESSING', 'delivery', '2023-07-26 15:43:52', null);
