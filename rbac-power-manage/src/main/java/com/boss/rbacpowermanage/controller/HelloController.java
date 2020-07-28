package com.boss.rbacpowermanage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 黄杰峰
 * @Date 2020/7/28 0028 9:23
 * @Description
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String welcome() {
        return "success";
    }
}
