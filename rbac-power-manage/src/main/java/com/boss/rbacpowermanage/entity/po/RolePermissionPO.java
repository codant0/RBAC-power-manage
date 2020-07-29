package com.boss.rbacpowermanage.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:37
 * @Description
 */
@Data
@TableName("sys_role_permission")
public class RolePermissionPO {
    private Integer rId;

    private Integer pId;

    public RolePermissionPO(){};

    public RolePermissionPO(Integer rId, Integer pId) {
        this.rId = rId;
        this.pId = pId;
    }
}
