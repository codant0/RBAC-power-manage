package com.boss.rbacpowermanage.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 14:15
 * @Description
 */
@TableName("sys_menu")
@Data
public class MenuPO {

    private int mId;

    private String mName;

    private String mDesc;

    private int mOrder;

    private String mStatus;
}
