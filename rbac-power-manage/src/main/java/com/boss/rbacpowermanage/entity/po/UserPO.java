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
 * @Date 2020/7/27 0027 13:58
 * @Description
 */
@Data
@TableName("sys_users")
public class UserPO implements Serializable {

    @TableId("u_id")
    private Integer uId;

    private String uName;

    private String uPassword;

    private String uPhone;

    private String uSex;

    private String uEmail;

    private Date uCreateTime;

    @TableField(exist = false)
    private List<RolePO> userRoles;
}
