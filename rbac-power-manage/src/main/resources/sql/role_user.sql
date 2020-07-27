CREATE TABLE sys_user_role(
	u_id INT(10) COMMENT "用户ID",
    r_id INT(5) COMMENT "角色ID",
    PRIMARY KEY(u_Id, r_Id),
    FOREIGN KEY(u_id) REFERENCES sys_users(u_id),
    FOREIGN KEY(r_id) REFERENCES sys_permissions(p_id)
);