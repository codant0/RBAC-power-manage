package com.boss.rbacpowermanage.service;

import com.boss.rbacpowermanage.entity.po.RolePO;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:58
 * @Description
 */
public interface RoleService {


    /**
     * 添加角色
     * @param role
     * @return
     */
    boolean addRole(RolePO role);

    /**
     * 删除角色
     * @param rId
     * @return
     */
    boolean deleteRole(Integer rId);

    /**
     * 更改用户
     * @param role
     * @return
     */
    boolean modifyRole(RolePO role);

    /**
     * 查找所有角色
     * @return
     */
    List<RolePO> findAllRoles();

    /**
     * 根据角色ID查找角色
     * @return
     * @param rId
     */
    RolePO findRoleById(Integer rId);
}
