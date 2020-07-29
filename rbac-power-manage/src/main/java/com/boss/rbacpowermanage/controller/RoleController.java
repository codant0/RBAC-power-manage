package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String addPermission(@RequestParam int roleId, @RequestParam int permissionId) {
        rolePermissionService.addRolePermission(roleId, permissionId);
        return "index";
    }
}
