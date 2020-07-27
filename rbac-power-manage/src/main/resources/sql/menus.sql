CREATE TABLE sys_menus(
	m_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "菜单ID",
    m_name VARCHAR(8) NOT NULL UNIQUE COMMENT "菜单名称",
    m_desc VARCHAR(20) NULL COMMENT "菜单描述",
    m_order INT(3) NOT NULL COMMENT "菜单顺序",
    m_status VARCHAR(10) NULL COMMENT "菜单状态"
);