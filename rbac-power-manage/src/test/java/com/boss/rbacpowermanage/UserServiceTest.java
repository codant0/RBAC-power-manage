package com.boss.rbacpowermanage;

import com.boss.rbacpowermanage.entity.dto.UserDTO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.mapper.UserMapper;
import com.boss.rbacpowermanage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/28 0028 10:13
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void copyPropsTest() {
        List<UserDTO> allUsers = userService.findAllUsers();
        List<UserPO> userPOS = userMapper.selectList(null);
        System.out.println("==========start==========.");
        for (UserDTO user : allUsers) {
            System.out.println(user);
        }
        System.out.println("==========end==========.");

        for (UserPO user : userPOS) {
            System.out.println(user);
        }
    }
}
