package com.boss.rbacpowermanage.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:56
 * @Description
 */
@Data
public class RoleVO implements Serializable {

    private Integer rId;

    private String rName;

    private String rDesc;
}
