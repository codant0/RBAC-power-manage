package com.boss.rbacpowermanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.rbacpowermanage.entity.po.PermissionPO;
import com.boss.rbacpowermanage.entity.po.RolePO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:41
 * @Description 角色持久层Mapper
 */
@Repository
public interface RoleMapper extends BaseMapper<RolePO> {

    /**
     * 根据角色id查找角色权限
     * @param rId
     * @return
     */
    List<PermissionPO> findRolePermissions(Integer rId);
}
