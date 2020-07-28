package com.boss.rbacpowermanage.service.impl;

import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.entity.po.UserRolePO;
import com.boss.rbacpowermanage.mapper.UserRoleMapper;
import com.boss.rbacpowermanage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:29
 * @Description
 */
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public boolean addUserRole(Integer uId, Integer rId) {
        return userRoleMapper.insert(new UserRolePO(uId, rId)) >= 1;
    }

    @Override
    public boolean deleteUserRole(Integer uId, Integer rId) {
        Map<String, Object> deleteMap = new HashMap<>(8);
        deleteMap.put("u_id", uId);
        deleteMap.put("r_id", rId);
        return userRoleMapper.deleteByMap(deleteMap) >= 1;
    }

    @Override
    public List<Integer> findUserRoleIds(Integer uId) {
        return null;
    }
}
