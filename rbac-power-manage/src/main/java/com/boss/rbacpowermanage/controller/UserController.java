package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 16:03
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        ModelAndView mv = new ModelAndView();
//        mv.setViewName("success");
        return "success";
    }
}
