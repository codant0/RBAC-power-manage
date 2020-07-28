package com.boss.rbacpowermanage.service;

import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.entity.dto.UserDTO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:58
 * @Description
 */
public interface UserService extends UserDetailsService {

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
    List<UserDTO> findAllUsers();

    /**
     * 根据ID查找用户
     * @return
     * @param id
     */
    UserDTO findUserById(Integer id);

    /**
     * 根据用户名查找用户
     * @return
     * @param username
     */
    UserDTO findUserDTOByUsername(String username);

    /**
     * 根据用户id查看用户可视的资源
     * @param id
     * @return
     */
    Set<Integer> findUserMenusByUId(Integer id);

}
