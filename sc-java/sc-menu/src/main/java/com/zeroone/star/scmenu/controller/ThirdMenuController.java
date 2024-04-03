package com.zeroone.star.scmenu.controller;


import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.menu.ThirdMenuApis;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.ThirdMenuVO;
import com.zeroone.star.scmenu.service.IMenuService;
import com.zeroone.star.scmenu.service.IRoleMenuService;
import com.zeroone.star.scmenu.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author liubowen
 * @since 2022-10-28
 */
@RestController
@RequestMapping("/scmenu/thirdMenu")
@Api(tags = "权限管理")
@Slf4j
@Transactional
public class ThirdMenuController implements ThirdMenuApis {

    @Resource
    IRoleMenuService roleMenuService;

    @Autowired
    IMenuService iMenuService;

    @GetMapping("/query-third-menu")
    @ApiOperation(value = "分页查询所有三级菜单")
    @Override
    public JsonVO<PageVO<ThirdMenuVO>> queryThirdMenu(@Validated ThirdMenuPageQuery thirdMenuPageQuery) {
        PageVO<ThirdMenuVO> thirdMenuVOPageVO = iMenuService.listThirdMenu(thirdMenuPageQuery);
        return JsonVO.success(thirdMenuVOPageVO);
    }

    @GetMapping("/query-a-third-menu")
    @ApiOperation(value = "根据三级菜单id和父级菜单id查询一个三级菜单")
    @Override
    public JsonVO<ThirdMenuDTO> queryAThirdMenu(@ApiParam(required = true) Integer id,
                                                @ApiParam(required = true) Integer parentMenuId) {
        ThirdMenuDTO thirdMenuDTO = iMenuService.getAThirdMenu(id, parentMenuId);
        if(thirdMenuDTO==null) return JsonVO.fail(null);
        return JsonVO.success(thirdMenuDTO);
    }

    @PostMapping("/add-third-menu")
    @ApiOperation(value = "添加三级菜单")
    @Override
    public JsonVO<String> saveThirdMenu(@Validated ThirdMenuDTO thirdMenuDTO) {
        //插入menu表数据
        int menuId = iMenuService.saveAThirdMenu(thirdMenuDTO);
        if(menuId>0) log.info("菜单信息添加成功");
        else return JsonVO.fail("添加菜单失败");

        //插入role_menu表数据
        int roleMenuId = roleMenuService.saveARoleMenu(thirdMenuDTO, menuId);
        if(roleMenuId>0) log.info("菜单对应管理员关系表添加成功");
        else return JsonVO.fail("添加菜单失败");

        return JsonVO.success("添加菜单成功");
    }

    @PutMapping("/modify-third-menu")
    @ApiOperation(value = "修改三级菜单")
    @Override
    public JsonVO<String> modifyThirdMenu(@Validated ThirdMenuDTO thirdMenuDTO) {
        //修改menu表数据
        int menuUpdate = iMenuService.updateThirdMenu(thirdMenuDTO);
        if(menuUpdate==0) return JsonVO.fail("修改菜单信息失败");
        else log.info("菜单信息修改成功");

        //修改role_menu表数据
        int roleMenuUpdate = roleMenuService.updateRoleMenu(thirdMenuDTO);
        if(roleMenuUpdate==0) return JsonVO.fail("修改菜单信息对应的管理员失败");
        else log.info("菜单信息对应角色修改成功");

        return JsonVO.success("修改菜单成功");
    }

    @DeleteMapping("/remove-third-menu")
    @ApiOperation(value = "删除三级菜单")
    @Override
    public JsonVO<String> removeThirdMenu(@ApiParam(required = true) String roleName,
                                          @ApiParam(required = true) Integer menuId) {
        //查询role_id
        Integer roleId = iMenuService.getRoleIdByRoleName(roleName);
        if(roleId==null || roleId==0) return JsonVO.fail("删除失败");

        Integer isRemoveRoleMenu = roleMenuService.removeRoleAndMenu(roleId, menuId);
        if(isRemoveRoleMenu==null || isRemoveRoleMenu==0) return JsonVO.fail("删除菜单绑定的管理员失败");
        else log.info("删除菜单绑定的管理员成功");

        Integer isRemove = iMenuService.removeThirdMenuById(menuId);
        if(isRemove==null || isRemove==0) return JsonVO.fail("删除菜单信息失败");
        else log.info("删除菜单成功");

        return JsonVO.success("删除成功");
    }
}

