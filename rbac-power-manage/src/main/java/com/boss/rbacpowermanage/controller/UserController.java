package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.service.UserRoleService;
import com.boss.rbacpowermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 16:03
 * @Description 用户相关操作控制器
 */
@Controller
public class UserController {

    private final UserService userService;

    private final UserRoleService userRoleService;

    @Autowired
    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        UserDO user = (UserDO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mv.setViewName("index");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/addRole")
    public ModelAndView addUserRole(@RequestParam int userId, @RequestParam int roleId) {

        ModelAndView mv = new ModelAndView();
        // 若该用户包含该角色，则不添加，否则添加，Model中添加相关信息
        if (userRoleService.hasRole(userId, roleId)) {
            mv.addObject("msg", "已拥有该角色，添加失败");
        } else {
            userRoleService.addUserRole(userId, roleId);
            mv.addObject("msg", "添加成功");
        }
        return mv;
    }

    public ModelAndView deleteUserRole(@RequestParam int userId, @RequestParam int roleId) {

        ModelAndView mv = new ModelAndView();
        // 若该用户包含该角色，成功删除，否则不删除，Model中添加相关信息
        if (userRoleService.hasRole(userId, roleId)) {
            userRoleService.deleteUserRole(userId, roleId);
            mv.addObject("msg", "删除成功");
        }
        mv.addObject("msg", "该用户无该角色，删除失败");
        mv.setViewName("index");
        return mv;
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
