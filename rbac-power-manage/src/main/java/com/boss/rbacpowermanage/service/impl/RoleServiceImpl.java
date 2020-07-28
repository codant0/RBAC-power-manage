package com.boss.rbacpowermanage.service.impl;

import com.boss.rbacpowermanage.entity.dto.RoleDTO;
import com.boss.rbacpowermanage.entity.po.PermissionPO;
import com.boss.rbacpowermanage.entity.po.RolePO;
import com.boss.rbacpowermanage.mapper.RoleMapper;
import com.boss.rbacpowermanage.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 16:02
 * @Description
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean addRole(RolePO role) {
        return roleMapper.insert(role) >= 1;
    }

    @Override
    public boolean deleteRole(Integer rId) {
        return roleMapper.deleteById(rId) >= 1;
    }

    @Override
    public boolean modifyRole(RolePO role) {
        return roleMapper.updateById(role) >= 1;
    }

    @Override
    public List<RoleDTO> findAllRoles() {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        List<RolePO> rolePOList = roleMapper.selectList(null);
        BeanUtils.copyProperties(rolePOList, roleDTOList);
        return roleDTOList;
    }

    @Override
    public RoleDTO findRoleById(Integer rId) {
        RoleDTO roleDTO = new RoleDTO();
        RolePO rolePO = roleMapper.selectById(rId);
        BeanUtils.copyProperties(rolePO, roleDTO);
        return roleDTO;
    }
}
