package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.entity.vo.UserVO;
import com.boss.rbacpowermanage.service.UserRoleService;
import com.boss.rbacpowermanage.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 16:03
 * @Description 用户相关操作控制器
 */
@RestController
@Log4j2
public class UserController {

    private final UserService userService;

    private final UserRoleService userRoleService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }



    @GetMapping("/index")
    public UserVO index() {
        UserDO userDO = (UserDO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVO user = new UserVO();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }

    @PostMapping("/addRole")
    public Map<String, String> addUserRole(@RequestParam int userId, @RequestParam int roleId) {

        Map<String, String> respMsg = new HashMap<>(4);

        // 若该用户包含该角色，则不添加，否则添加，Model中添加相关信息
        if (userRoleService.hasRole(userId, roleId)) {
            respMsg.put("msg", "已拥有该角色，添加失败");
        } else {
            userRoleService.addUserRole(userId, roleId);
            respMsg.put("msg", "添加成功");
        }
        return respMsg;
    }

    @PostMapping("/deleteRole")
    public Map deleteUserRole(@RequestParam int userId, @RequestParam int roleId) {

        Map<String, String> respMsg = new HashMap<>(4);

        // 若该用户包含该角色，成功删除，否则不删除，Model中添加相关信息
        if (userRoleService.hasRole(userId, roleId)) {
            userRoleService.deleteUserRole(userId, roleId);
            respMsg.put("msg", "删除成功");
        } else {
            respMsg.put("msg", "该用户无该角色，删除失败");
        }
        return respMsg;
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
