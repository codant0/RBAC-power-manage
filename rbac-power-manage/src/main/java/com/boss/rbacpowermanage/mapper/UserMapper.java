package com.boss.rbacpowermanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.rbacpowermanage.entity.po.UserPO;
import org.springframework.stereotype.Repository;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:41
 * @Description 用户相关数据库操作接口
 */
@Repository
public interface UserMapper extends BaseMapper<UserPO> {

    /**
     * 判断数据库中是否存在指定用户名和密码
     * @param username
     * @param password
     * @return
     */
    Integer SearchUsernameAndPassword(String username, String password);

    
}
