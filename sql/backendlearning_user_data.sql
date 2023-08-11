create table user_data
(
    id           bigint(10) auto_increment comment '个人ID'
        primary key,
    created_time timestamp   null comment '创建时间',
    update_time  timestamp   null on update CURRENT_TIMESTAMP comment '最近编辑时间',
    real_name    varchar(20) null comment '真实姓名',
    role         varchar(20) null comment '用户角色',
    user_name    varchar(20) null comment '用户名',
    password     varchar(30) null comment '密码'
);

INSERT INTO backendlearning.user_data (id, created_time, update_time, real_name, role, user_name, password) VALUES (1, '2023-07-18 10:35:26', '2023-07-26 15:10:02', '管理员2号', 'role1', 'admin2', 'admin');
INSERT INTO backendlearning.user_data (id, created_time, update_time, real_name, role, user_name, password) VALUES (2, '2023-07-18 10:43:02', '2023-07-24 17:58:42', '管理员1号', '管理员', 'admin1', 'admin');
INSERT INTO backendlearning.user_data (id, created_time, update_time, real_name, role, user_name, password) VALUES (3, '2023-07-19 16:38:05', '2023-07-24 17:58:47', '测试员1号', '测试员', 'tester1', '123123');
INSERT INTO backendlearning.user_data (id, created_time, update_time, real_name, role, user_name, password) VALUES (4, '2023-07-25 10:16:20', '2023-07-26 14:58:14', 'AAAAAA', 'role2', 'aa', '111122');
