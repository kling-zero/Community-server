package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.dto.rolePrivilege.roleFunction.RoleAssFunctionDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleFunctionQuery;
import com.zeroone.star.project.rolePrivilege.roleFunction.UserAssFunctionApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleNotFunctionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pzi
 * @create 2022-10-16 15:44
 */
@RestController
@RequestMapping("userPrivilege")
@Api(tags = "角色和功能关联")
public class UserAssFunctionController implements UserAssFunctionApis {


    @ApiOperation(value = "查询该权限组没有的权限")
    @GetMapping("listRoleNotFunction")
    @Override
    public JsonVO<RoleNotFunctionVO> roleNotFunction(RoleFunctionQuery roleFunctionQuery) {
        return null;
    }

    @ApiOperation(value = "角色和功能关联")
    @PostMapping("roleAssFunction")
    @Override
    public JsonVO<Object> roleAssociatedFunction(RoleAssFunctionDTO roleAssFunctionDTO) {
        return null;
    }

    @ApiOperation(value = "角色和功能取消关联")
    @PostMapping("deleteRoleAssFunction")
    @Override
    public JsonVO<Object> deleteRoleAssFunction(RoleAssFunctionDTO roleAssFunctionDTO) {
        return null;
    }
}
