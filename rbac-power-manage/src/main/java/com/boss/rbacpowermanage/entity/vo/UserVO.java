package com.boss.rbacpowermanage.entity.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:50
 * @Description
 */
@Data
public class UserVO implements Serializable {

    private Integer uId;

    private String uName;

    private String uPassword;

    private String uPhone;

    private String uSex;

    private String uEmail;

    private Collection<? extends GrantedAuthority> authorities;

    private String msg;
}
