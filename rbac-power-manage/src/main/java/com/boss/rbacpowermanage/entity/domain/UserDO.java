package com.boss.rbacpowermanage.entity.domain;

import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:30
 * @Description
 */
@Data
public class UserDO {

    private Integer uId;

    private String uName;

    private String uPassword;

    private String uPhone;

    private String uSex;

    private String uEmail;
}
