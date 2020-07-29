package com.boss.rbacpowermanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boss.rbacpowermanage.entity.po.PermissionPO;
import com.boss.rbacpowermanage.entity.po.RolePermissionPO;
import com.boss.rbacpowermanage.mapper.RoleMapper;
import com.boss.rbacpowermanage.mapper.RolePermissionMapper;
import com.boss.rbacpowermanage.mapper.UserMapper;
import com.boss.rbacpowermanage.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:42
 * @Description
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RoleMapper roleMapper;
    private final UserMapper userMapper;
    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    RolePermissionServiceImpl(RoleMapper roleMapper,
                              UserMapper userMapper,
                              RolePermissionMapper rolePermissionMapper) {
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public boolean addRolePermission(Integer rId, Integer pId) {
        return rolePermissionMapper.insert(new RolePermissionPO(rId, pId)) >= 1;
    }

    @Override
    public boolean deleteRolePermission(Integer rId, Integer pId) {
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("r_id", rId);
        deleteMap.put("p_id", pId);
        return rolePermissionMapper.deleteByMap(deleteMap) >= 1;
    }

    @Override
    public List<Integer> findRolePermissionIds(Integer roleId) {
        List<PermissionPO> rolePermissions = roleMapper.findRolePermissions(roleId);
        List<Integer> permissionIds = new ArrayList<>();
        for (PermissionPO permission : rolePermissions) {
            permissionIds.add(permission.getPId());
        }
        return permissionIds;
    }

    @Override
    public boolean hasPermission(Integer roleId, Integer permissionId) {

        RolePermissionPO rolePermissionPO = new RolePermissionPO(roleId, permissionId);
        return rolePermissionMapper.selectOne(new QueryWrapper<>(rolePermissionPO)) != null;
    }
}
