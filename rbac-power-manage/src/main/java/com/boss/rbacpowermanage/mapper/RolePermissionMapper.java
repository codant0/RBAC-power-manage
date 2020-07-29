package com.boss.rbacpowermanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.rbacpowermanage.entity.po.RolePermissionPO;
import org.springframework.stereotype.Repository;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:40
 * @Description 涉及角色和权限（都包含）的Mapper
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermissionPO> {
}
