package com.boss.rbacpowermanage;

import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import com.boss.rbacpowermanage.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:12
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<UserPO> users = userMapper.selectList(null);
        logger.info(users);
    }


    @Test
    public void SearchUsernameAndPassword() {

        Integer tag = userMapper.SearchUsernameAndPassword("lily", "123456");
        logger.info(tag);

    }
}
