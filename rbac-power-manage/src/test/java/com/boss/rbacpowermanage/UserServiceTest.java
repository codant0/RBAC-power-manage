package com.boss.rbacpowermanage;

import com.boss.rbacpowermanage.entity.dto.UserDTO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.mapper.UserMapper;
import com.boss.rbacpowermanage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

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

    @Test
    public void loadUserByUsernameTest() {
        UserDetails xiaoming = userService.loadUserByUsername("xiaoming");
        System.out.println(xiaoming);
    }

    @Test
    public void findUserMenuIds() {
        Set<Integer> userMenusByUId = userService.findUserMenusByUId(2);
        for (Integer id : userMenusByUId) {
            System.out.println(id);
        }
    }

}
