package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.dto.rolePrivilege.RoleDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleAssStaffDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleNotAssStaffDTO;
import com.zeroone.star.project.dto.setting.MenuRoleDTO;
import com.zeroone.star.project.rolePrivilege.UserPrivilegeApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.role.RoleVO;
import com.zeroone.star.scsetting.service.UserPrivilegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Pzi
 * @create 2022-10-16 15:34
 */
@RestController
@RequestMapping("userPrivilege")
@Api(tags = "用户权限")
public class UserPrivilegeController implements UserPrivilegeApis {
    @Resource
    UserPrivilegeService userPrivilegeService;

    @Resource
    UserHolder userHolder;

    @ApiOperation(value = "展示所有角色")
    @GetMapping("listAllRoles")
    @Override
    public JsonVO<List<RoleVO>> listAllRoles() {
        UserDTO currentUser;
        try {
            currentUser = userHolder.getCurrentUser();
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), e.getMessage());
        }
        Integer id = currentUser.getId();
        return JsonVO.success(userPrivilegeService.listAll(id));

    }

    @ApiOperation(value = "添加角色")
    @PostMapping("addRole")
    @Override
    public JsonVO<String> addRole(RoleDTO roleDTO) {
        try {
            userPrivilegeService.addRole(roleDTO);
            return JsonVO.success("添加角色成功");
        } catch (Exception e) {
            return JsonVO.fail(e.getMessage());
        }
    }

    @ApiOperation(value = "修改角色")
    @PostMapping("updateRole")
    @Override
    public JsonVO<String> updateRole(RoleDTO roleDTO) {
        userPrivilegeService.updateRole(roleDTO);
        return JsonVO.success("操作成功");
    }

    @ApiOperation(value = "删除角色")
    @PostMapping("deleteRole")
    @Override
    public JsonVO<String> deleteRole(RoleDTO roleDTO) {
        userPrivilegeService.deleteRole(roleDTO);
        return JsonVO.success("操作成功");
    }

    @ApiOperation(value = "添加角色菜单")
    @PostMapping("insertMenu")
    @Override
    public JsonVO<String> insertMenu(MenuRoleDTO menuRoleDTO) {
        userPrivilegeService.insertMenu(menuRoleDTO);
        return JsonVO.success("操作成功");
    }

    @ApiOperation(value = "删除角色菜单")
    @PostMapping("deleteMenu")
    @Override
    public JsonVO<String> deleteMenu(MenuRoleDTO menuRoleDTO) {
        userPrivilegeService.deleteMenu(menuRoleDTO);
        return JsonVO.success("操作成功");
    }

}
