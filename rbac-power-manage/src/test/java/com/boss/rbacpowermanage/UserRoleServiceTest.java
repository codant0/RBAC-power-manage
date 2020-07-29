package com.boss.rbacpowermanage;

import com.boss.rbacpowermanage.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 黄杰峰
 * @Date 2020/7/29 0029 9:27
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleServiceTest {

    @Autowired
    UserRoleService userRoleService;

    @Test
    public void hasRoleTest() {
        boolean b = userRoleService.hasRole(2, 4);
        System.out.println(b);
    }
}
