package com.boss.rbacpowermanage.service;

import com.boss.rbacpowermanage.entity.po.UserPO;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:58
 * @Description
 */
public interface UserService {

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * 添加用户
     * @param userPO
     * @return
     */
    boolean add(UserPO userPO);

    /**
     * 删除用户
     * @param uId
     * @return
     */
    boolean delete(Integer uId);

    /**
     * 修改用户信息
     * @param userPO
     * @return
     */
    boolean modify(UserPO userPO);

    /**
     * 查找所有用户
     * @return
     */
    List<UserPO> findAllUsers();

    /**
     * 根据ID查找用户
     * @return
     * @param id
     */
    UserPO findUserById(Integer id);

    /**
     * 根据用户名查找用户
     * @return
     * @param username
     */
    UserPO findUserByUsername(String username);
}
