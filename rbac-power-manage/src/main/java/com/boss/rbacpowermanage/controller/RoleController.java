package com.boss.rbacpowermanage.controller;

import com.boss.rbacpowermanage.service.RolePermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 18:53
 * @Description 角色相关操作控制器
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RolePermissionService rolePermissionService;

    public RoleController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping("/addPermission")
    public Map addPermission(@RequestParam int roleId, @RequestParam int permissionId) {

        Map<String, String> respMsg = new HashMap<>();

        if (rolePermissionService.hasPermission(roleId, permissionId)) {
            respMsg.put("msg", "该角色已拥有该权限，添加失败");
        } else {
            rolePermissionService.addRolePermission(roleId, permissionId);
            respMsg.put("msg", "添加成功");
        }
        return respMsg;
    }

    @PostMapping("/deletePermission")
    public Map<String, String> deletePermission(@RequestParam int roleId, @RequestParam int permissionId) {

        Map<String, String> respMsg = new HashMap<>();

        if (rolePermissionService.hasPermission(roleId, permissionId)) {
            rolePermissionService.deleteRolePermission(roleId, permissionId);
            respMsg.put("msg", "删除成功");
        } else {
            respMsg.put("msg", "该用户没有该权限，删除失败");
        }
        return respMsg;
    }
}
