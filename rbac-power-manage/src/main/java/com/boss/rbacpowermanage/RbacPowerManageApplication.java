package com.boss.rbacpowermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boss.rbacpowermanage.mapper")
public class RbacPowerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacPowerManageApplication.class, args);
    }

}
