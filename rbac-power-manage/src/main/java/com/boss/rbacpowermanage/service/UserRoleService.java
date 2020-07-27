package com.boss.rbacpowermanage.service;

import com.boss.rbacpowermanage.entity.po.RolePO;
import com.boss.rbacpowermanage.entity.po.UserPO;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:29
 * @Description
 */
public interface UserRoleService {

    /**
     * 添加用户角色
     * @param uId
     * @param rId
     * @return
     */
    boolean addUserRole(Integer uId, Integer rId);

    /**
     * 删除用户角色
     * @param uId
     * @param rId
     * @return
     */
    boolean deleteUserRole(Integer uId, Integer rId);

    /**
     * 根据用户id查找角色id
     * @param uId
     * @return
     */
    List<Integer> findUserRoleIds(Integer uId);
}
