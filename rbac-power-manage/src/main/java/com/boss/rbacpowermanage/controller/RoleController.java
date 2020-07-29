package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.service.RolePermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 18:53
 * @Description
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RolePermissionService rolePermissionService;

    public RoleController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping("/addPermission")
    public ModelAndView addPermission(@RequestParam int roleId, @RequestParam int permissionId) {

        ModelAndView mv = new ModelAndView();

        if (rolePermissionService.hasPermission(roleId, permissionId)) {
            mv.addObject("msg", "该角色已拥有该权限，添加失败");
        } else {
            rolePermissionService.addRolePermission(roleId, permissionId);
            mv.addObject("msg", "添加成功");
        }
        mv.setViewName("index");
        return mv;
    }
    
    public ModelAndView deletePermission(@RequestParam int roleId, @RequestParam int permissionId) {
        ModelAndView mv = new ModelAndView();

        if (rolePermissionService.hasPermission(roleId, permissionId)) {
            rolePermissionService.deleteRolePermission(roleId, permissionId);
            mv.addObject("msg", "删除成功");
        } else {
            mv.addObject("msg", "该用户没有该权限，删除失败");
        }
        mv.setViewName("index");
        return mv;
    }
}
