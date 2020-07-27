package com.boss.rbacpowermanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.mapper.UserMapper;
import com.boss.rbacpowermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:58
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
    public List<UserPO> findAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public UserPO findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserPO findUserByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<UserPO>().eq("u_name", username));
    }
}
