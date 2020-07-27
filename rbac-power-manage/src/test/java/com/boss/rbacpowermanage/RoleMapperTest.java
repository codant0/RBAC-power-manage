package com.boss.rbacpowermanage;

import com.boss.rbacpowermanage.entity.po.PermissionPO;
import com.boss.rbacpowermanage.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 17:16
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void findRolePermissionsTest() {
        List<PermissionPO> rolePermissions = roleMapper.findRolePermissions(2);
        for (PermissionPO permission : rolePermissions) {
            System.out.println(permission);
        }
    }
}
