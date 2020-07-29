package com.boss.rbacpowermanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.rbacpowermanage.entity.po.RolePO;
import com.boss.rbacpowermanage.entity.po.UserRolePO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:39
 * @Description 包含User和Role二者的数据库操作接口
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRolePO> {

    /**
     * 根据用户id返回用户角色列表
     * @param uId
     * @return
     */
    List<RolePO> findUserRoles(Integer uId);
}
