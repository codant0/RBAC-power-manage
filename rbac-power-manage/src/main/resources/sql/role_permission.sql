CREATE TABLE sys_role_permission(
	r_id INT(5) COMMENT "角色ID",
    p_id INT(5) COMMENT "权限ID",
    PRIMARY KEY(r_id,p_id),
    FOREIGN KEY(r_id) REFERENCES sys_roles(r_id),
    FOREIGN KEY(p_id) REFERENCES sys_permissions(p_id)
);