package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 16:03
 * @Description
 */
@Controller
//@ResponseBody
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        Set<Integer> userMenusByUId = userService.findUserMenusByUId(2);
        model.addAttribute("menus", userMenusByUId);
        return "index";
    }

    /**
     * menu1按钮
     * @return
     */
    @PreAuthorize("hasAuthority('menu1')")
    @GetMapping("menu1")
    @ResponseBody
    public String menu1() {
        return "menu1";
    }

    /**
     * menu2按钮
     * @return
     */
    @PreAuthorize("hasAuthority('menu2')")
    @GetMapping("menu2")
    @ResponseBody
    public String menu2() {
        return "menu2";
    }

    /**
     * menu3按钮
     * @return
     */
    @PreAuthorize("hasAuthority('menu3')")
    @GetMapping("menu3")
    @ResponseBody
    public String menu3() {
        return "menu3";
    }

    /**
     * menu4按钮
     * @return
     */
    @PreAuthorize("hasAuthority('menu4')")
    @GetMapping("menu4")
    @ResponseBody
    public String menu4() {
        return "menu4";
    }

    /**
     * admin按钮
     * @return
     */
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }
}
