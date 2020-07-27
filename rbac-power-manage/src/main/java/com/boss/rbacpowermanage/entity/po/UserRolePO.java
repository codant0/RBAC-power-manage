package com.boss.rbacpowermanage.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 19:37
 * @Description
 */
@TableName("sys_user_role")
@Data
public class UserRolePO {

    @TableField("u_id")
    private Integer uId;

    @TableField("r_id")
    private Integer rId;

    public UserRolePO() {}

    public UserRolePO(Integer uId, Integer rId) {
        this.uId = uId;
        this.rId = rId;
    }
}
