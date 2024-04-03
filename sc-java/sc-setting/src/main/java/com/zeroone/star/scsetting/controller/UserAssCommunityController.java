package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.dto.rolePrivilege.roleCommunity.RoleAssCommunityDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleCommunity.RoleNotAssCommunityDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleCommunityQuery;
import com.zeroone.star.project.rolePrivilege.roleCommunity.UserAssCommunityApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleCommunityVO;
import com.zeroone.star.project.vo.role.RoleNotCommunityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pzi
 * @create 2022-10-16 15:47
 */

@RestController
@RequestMapping("userPrivilege")
@Api(tags = "角色和社区关联")
public class UserAssCommunityController implements UserAssCommunityApis {


    @ApiOperation(value = "角色和社区关联")
    @PostMapping("roleAssCommunity")
    @Override
    public JsonVO<Object> roleAssociatedCommunity(RoleAssCommunityDTO roleAssCommunityDTO) {
        return null;
    }

    @ApiOperation(value = "角色和社区取消关联")
    @PostMapping("deleteRoleAssCommunity")
    @Override
    public JsonVO<Object> deleteRoleAssCommunity(RoleNotAssCommunityDTO roleNotAssCommunityDTO) {
        return null;
    }

    @ApiOperation(value = "查询该角色关联的所有小区")
    @GetMapping("listRoleCommunity")
    @Override
    public JsonVO<RoleCommunityVO> listRoleCommunity(RoleCommunityQuery roleCommunityQuery) {
        return null;
    }

    @ApiOperation(value = "查询不与该角色关联的所有小区")
    @GetMapping("listRoleNotCommunity")
    @Override
    public JsonVO<RoleNotCommunityVO> listRoleNotCommunity(RoleCommunityQuery roleCommunityQuery) {
        return null;
    }
}
