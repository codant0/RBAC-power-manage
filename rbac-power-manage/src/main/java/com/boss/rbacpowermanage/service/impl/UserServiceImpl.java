package com.boss.rbacpowermanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.entity.dto.UserDTO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.mapper.UserMapper;
import com.boss.rbacpowermanage.service.RolePermissionService;
import com.boss.rbacpowermanage.service.UserRoleService;
import com.boss.rbacpowermanage.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:58
 * @Description User业务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserRoleService userRoleService;

    private final RolePermissionService rolePermissionService;

    @Autowired
    UserServiceImpl(UserMapper userMapper,
                    PasswordEncoder passwordEncoder,
                    UserRoleService userRoleService,
                    RolePermissionService rolePermissionService) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    @Override
    public boolean login(String username, String password) {
        return userMapper.SearchUsernameAndPassword(username, password) >= 1;
    }

    @Override
    public boolean add(UserPO userPO) {
        return userMapper.insert(userPO) >= 1;
    }

    @Override
    public boolean delete(Integer uId) {
        return userMapper.deleteById(uId) >= 1;
    }

    @Override
    public boolean modify(UserPO userPO) {
        return userMapper.updateById(userPO) >= 1;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserPO> userPOList = userMapper.selectList(null);
        for (UserPO user : userPOList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO findUserById(Integer id) {
        UserPO userPO = userMapper.selectById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userPO, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findUserDTOByUsername(String username) {
        return null;
    }

    @Override
    public Set<Integer> findUserMenusByUId(Integer id) {
        Set<Integer> userPermissions = new HashSet<>();
        List<Integer> userRoleIds = userRoleService.findUserRoleIds(id);
        for (Integer userRoleId : userRoleIds) {
            List<Integer> rolePermissionIds = rolePermissionService.findRolePermissionIds(userRoleId);
            userPermissions.addAll(rolePermissionIds);
        }
        Set<Integer> userMenuIds = userPermissions;
        return userMenuIds;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = new UserDO();
        UserPO userPO = userMapper.selectOne(new QueryWrapper<UserPO>().eq("u_name", username));
        BeanUtils.copyProperties(userPO, userDO);
        if (userDO == null) {
            throw new UsernameNotFoundException("不存在该用户!");
        } else {
            //设置权限信息
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            List<Integer> userRoleIds = userRoleService.findUserRoleIds(userDO.getUId());
            Set<Integer> userPermissionIds = new HashSet<>();
            Set<Integer> userMenuIds;

            for (Integer roleId : userRoleIds) {
                userPermissionIds.addAll(rolePermissionService.findRolePermissionIds(roleId));
            }

            // 此处一个权限对应一个菜单资源，后期需要改正
            userMenuIds = userPermissionIds;

            for (Integer menuId : userMenuIds) {
                //资源key作为权限标识
                grantedAuthorities.add(new SimpleGrantedAuthority("menu" + menuId.toString()));
                userDO.setAuthorities(grantedAuthorities);
            }
        }

        // 密码加密
        userDO.setUPassword(this.passwordEncoder.encode(userDO.getPassword()));
        return userDO;
    }

}
