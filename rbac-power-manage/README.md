# SpringSecurity 实现RBAC

[toc]

## 实现

* RBAC权限划分
* 使用SpringSecurity实现动态权限控制
* Thymeleaf及其标签库实现同一页面视图资源控制
* 将项目注册到Nacos中心（配置文件放在注册中心内）
* RBAC微服务网关配置



## RBAC表结构

* Users

  ``` sql
  CREATE TABLE sys_users(
      u_id INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT "用户id",
      u_name VARCHAR(15) NOT NULL UNIQUE COMMENT "用户名",
      u_password VARCHAR(20) NOT NULL COMMENT "密码",
      u_phone CHAR(11) NULL COMMENT "电话",
      u_sex CHAR(6) NULL COMMENT "性别",
      u_email varchar(20) NULL COMMENT "邮箱",
      u_create_time DATETIME COMMENT "创建时间"
  );
  ```

  

* Roles

  ``` sql
  CREATE TABLE sys_roles(
  	r_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "角色id",
      r_name VARCHAR(8) NOT NULL UNIQUE COMMENT "角色名称",
      r_desc VARCHAR(20) NULL COMMENT "角色描述",
      r_create_time DATETIME COMMENT "创建时间",
      r_creator VARCHAR(10) COMMENT "创建者"
  );
  ```

  

* Permissions （认为资源可以依附于权限下）

  ``` sql
  CREATE TABLE sys_permissions(
  	p_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "权限id",
      p_name VARCHAR(8) NOT NULL UNIQUE COMMENT "权限名称",
      p_desc VARCHAR(20) NULL COMMENT "权限描述",
      m_id INT(5)  NOT NULL COMMENT "菜单ID",
      FOREIGN KEY (m_id) REFERENCES sys_menus(m_id)
  );
  ```

  

* Menus

  ``` sql
  CREATE TABLE sys_menus(
  	m_id INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT "菜单ID",
      m_name VARCHAR(8) NOT NULL UNIQUE COMMENT "菜单名称",
      m_desc VARCHAR(20) NULL COMMENT "菜单描述",
      m_order INT(3) NOT NULL COMMENT "菜单顺序",
      m_status VARCHAR(10) NULL COMMENT "菜单状态"
      m_create_time DATETIME COMMENT "创建时间"
  );
  ```

  

* 多对多中间表

  * user_role

    ``` sql
    CREATE TABLE sys_user_role(
    	u_id INT(10) COMMENT "用户ID",
        r_id INT(5) COMMENT "角色ID",
        PRIMARY KEY(u_Id, r_Id),
        FOREIGN KEY(u_id) REFERENCES sys_users(u_id),
        FOREIGN KEY(r_id) REFERENCES sys_permissions(p_id)
    );
    ```

    

  * role_permission

    ``` sql
    CREATE TABLE sys_role_permission(
    	r_id INT(5) COMMENT "角色ID",
        p_id INT(5) COMMENT "权限ID",
        PRIMARY KEY(r_id,p_id),
        FOREIGN KEY(r_id) REFERENCES sys_roles(r_id),
        FOREIGN KEY(p_id) REFERENCES sys_permissions(p_id)
    );
    ```

    



## SpringSecurity认证流程

* 待补充

## 存在问题

* VO、DTO、DO、PO划分非常混乱
* 使用的是较为低级的RBAC0结构
* 模版引擎使用极差
* 表功能不完善
* 未结合Nacos、Gateway
* 乐观锁？
* **前后端分离**



## 短期规划

- [ ] 结合Nacos、Gateway

- [x] 理清VO、DTO、DO、PO划分，修改Object的使用

- [ ] 添加表字段使其完善

- [ ] 了解乐观锁
- [ ] 考虑更高层次的RBAC结构
- [x] 前后端分离