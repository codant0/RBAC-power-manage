package com.boss.rbacpowermanage.service;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:42
 * @Description
 */
public interface RolePermissionService {

    /**
     * 添加角色权限
     * @param rId
     * @param pId
     * @return
     */
    boolean addRolePermission(Integer rId, Integer pId);

    /**
     * 删除角色权限
     * @param rId
     * @param pId
     * @return
     */
    boolean deleteRolePermission(Integer rId, Integer pId);

    /**
     * 根据角色id获取权限id列表
     * @param roleId
     * @return
     */
    List<Integer> findRolePermissionIds(Integer roleId);

}
