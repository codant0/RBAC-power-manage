CREATE TABLE sys_roles(
	r_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "角色id",
    r_name VARCHAR(8) NOT NULL UNIQUE COMMENT "角色名称",
    r_desc VARCHAR(20) NULL COMMENT "角色描述",
    r_create_time DATETIME COMMENT "创建时间",
    r_creator VARCHAR(10) COMMENT "创建者"
);