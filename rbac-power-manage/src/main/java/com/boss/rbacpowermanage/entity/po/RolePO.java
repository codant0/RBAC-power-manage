package com.boss.rbacpowermanage.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:10
 * @Description
 */
@Data
@TableName("sys_roles")
public class RolePO implements Serializable {

    @TableId("r_id")
    private Integer rId;

    private String rName;

    private String rDesc;

    private Date rCreateTime;

    private String rCreator;

    @TableField(exist = false)
    private List<PermissionPO> rolePermissions;
}
