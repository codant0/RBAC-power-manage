package com.boss.rbacpowermanage.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:11
 * @Description
 */
@TableName("sys_permissions")
@Data
public class PermissionPO {

    @TableId("p_id")
    private int pId;

    private String pName;

    private String pDesc;

    private int mId;
}
