create table task_data
(
    id         bigint(10) auto_increment
        primary key,
    plan_id    bigint(10)  null,
    `rank`     int         null,
    task_type  varchar(30) null,
    tester_num int         null
);

INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (1, 1, 1, 'detach', 1);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (2, 1, 3, 'delivery', 1);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (3, 1, 2, 'detach', 1);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (4, 1, 4, 'delivery', 1);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (5, 1, 5, 'delivery', 1);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (6, 2, 1, 'detach', 3);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (7, 3, 2, 'detach', 2);
INSERT INTO backendlearning.task_data (id, plan_id, `rank`, task_type, tester_num) VALUES (8, 3, 2, 'detach', 3);
