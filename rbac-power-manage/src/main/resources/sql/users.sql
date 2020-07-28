CREATE TABLE sys_users(
    u_id INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT "用户id",
    u_name VARCHAR(15) NOT NULL UNIQUE COMMENT "用户名",
    u_password VARCHAR(20) NOT NULL COMMENT "密码",
    u_phone CHAR(11) NULL COMMENT "电话",
    u_sex CHAR(6) NULL COMMENT "性别",
    u_email varchar(20) NULL COMMENT "邮箱",
    u_create_time DATETIME COMMENT "创建时间"
);