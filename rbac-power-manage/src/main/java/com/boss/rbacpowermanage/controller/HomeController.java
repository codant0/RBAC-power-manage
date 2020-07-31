package com.boss.rbacpowermanage.controller;

import com.netflix.client.http.HttpResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 黄杰峰
 * @Date 2020/7/29 0029 14:42
 * @Description
 */
@RestController
@Log4j2
@CrossOrigin
public class HomeController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/login")
    public String login(/*@RequestBody String body*/) {
//        log.info(request);
//        log.info("username: " + username);
//        log.info("password: " + password);
//        log.info(body);
        return "login";
    }

    @PostMapping("/test")
    public String test(@RequestBody String body) {
        log.info(body);
        return "test";
    }

    @GetMapping("/logout/success")
    public String logout() {
        return "logout";
    }
}
