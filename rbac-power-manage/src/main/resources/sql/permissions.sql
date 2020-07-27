CREATE TABLE sys_permissions(
	p_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "权限id",
    p_name VARCHAR(8) NOT NULL UNIQUE COMMENT "权限名称",
    p_desc VARCHAR(20) NULL COMMENT "权限描述",
    m_id INT(5)  NOT NULL COMMENT "菜单ID",
    FOREIGN KEY (m_id) REFERENCES sys_menus(m_id)
);