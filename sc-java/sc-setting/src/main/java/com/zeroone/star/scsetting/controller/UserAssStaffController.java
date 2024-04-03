package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleAssStaffDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleNotAssStaffDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleStaffQuery;
import com.zeroone.star.project.rolePrivilege.roleStaff.UserAssStaffApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.StaffVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Pzi
 * @create 2022-10-16 15:40
 */
@RestController
@RequestMapping("userPrivilege")
@Api(tags = "用户、角色关联")
public class UserAssStaffController implements UserAssStaffApis {

    @ApiOperation(value = "用户、角色关联")
    @PostMapping("roleAssociatedStaff")
    @Override
    public JsonVO<Object> roleAssociatedStaff(RoleAssStaffDTO roleAssStaffDTO) {
        return null;
    }

    @ApiOperation(value = "用户、角色取消关联")
    @PostMapping("deleteRoleAssStaff")
    @Override
    public JsonVO<Object> deleteRoleAssStaff(RoleNotAssStaffDTO roleNotAssStaffDTO) {
        return null;
    }

    @ApiOperation(value = "根据 roleID 查询该角色关联的所有员工")
    @GetMapping("listRoleStaff")
    @Override
    public JsonVO<List<StaffVO>> listRoleStaff(RoleStaffQuery roleStaffQuery) {
        return null;
    }

    @ApiOperation(value = "根据 roleID 查询该角色关联的所有员工")
    @GetMapping("listStaffNoRole")
    @Override
    public JsonVO<List<StaffVO>> listStaffNoRole(RoleStaffQuery roleStaffQuery) {
        return null;
    }
}
