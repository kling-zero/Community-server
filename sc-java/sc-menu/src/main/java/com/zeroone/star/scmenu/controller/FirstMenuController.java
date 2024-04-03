package com.zeroone.star.scmenu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.menu.FirstMenuApis;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.menu.FirstMenuVO;
import com.zeroone.star.scmenu.entity.Menu;
import com.zeroone.star.scmenu.entity.Role;
import com.zeroone.star.scmenu.entity.RoleMenu;
import com.zeroone.star.scmenu.service.IMenuService;
import com.zeroone.star.scmenu.service.IRoleMenuService;
import com.zeroone.star.scmenu.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/scmenu/first/menu")
@Api(tags = "菜单目录")
@Slf4j
@Transactional
public class FirstMenuController implements FirstMenuApis {

    @Autowired
    IMenuService menuService;

    @Resource
    IRoleMenuService roleMenuService;

    @Resource
    IRoleService roleService;

    @Override
    @ApiOperation(value = "分页查询所有一级菜单")
    @GetMapping("list-first-menu")
    public JsonVO<PageVO<FirstMenuVO>> listFirstMenu(FirstMenuPageQuery firstMenuPageQuery) {
        Page<FirstMenuDTO> firstMenuDTOPage = menuService.listFirstMenu(firstMenuPageQuery);
        PageVO<FirstMenuVO> firstMenuVOPageVO = PageVO.create(firstMenuDTOPage, FirstMenuVO.class);
        return JsonVO.success(firstMenuVOPageVO);
    }

    @Override
    @ApiOperation(value = "添加一级菜单")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PostMapping("add-first-menu")
    public JsonVO<String> addFirstMenu(FirstMenuDTO firstMenuDTO) {
        Role role = roleService.getOne(new LambdaQueryWrapper<Role>().eq(Role::getName, firstMenuDTO.getRoleName()));
        if (role == null) {
            log.error("没有该商户");
            return JsonVO.fail("没有该商户", ResultStatus.ROLE_UN_FOUND);
        }
        Menu newFirstMenu = new Menu();
        BeanUtils.copyProperties(firstMenuDTO, newFirstMenu, "id");
        newFirstMenu.setLevel(1);
        newFirstMenu.setCreateTime(LocalDateTime.now());
        menuService.save(newFirstMenu);
        log.info("菜单保存成功");

        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(role.getId());
        roleMenu.setMenuId(newFirstMenu.getId());
        roleMenu.setCreateTime(LocalDateTime.now());
        if (roleMenuService.save(roleMenu)) {
            log.info("菜单权限对应关系表保存成功");
            return JsonVO.success("添加成功！");
        } else {
            return JsonVO.fail("添加失败！", ResultStatus.FAIL);
        }

    }

    @Override
    @ApiOperation(value = "修改一级菜单")
    @PutMapping("update-first-menu")
    public JsonVO<String> updateFirstMenu(FirstMenuDTO firstMenuDTO) {
        Role role = roleService.getOne(new LambdaQueryWrapper<Role>().eq(Role::getName, firstMenuDTO.getRoleName()));
        if (role == null) {
            log.error("没有该商户");
            return JsonVO.fail("没有该商户", ResultStatus.ROLE_UN_FOUND);
        }
        Menu newFirstMenu = new Menu();
        BeanUtils.copyProperties(firstMenuDTO, newFirstMenu, "id");
        //根据 linkUrl 查询 menu
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getLinkUrl, firstMenuDTO.getLinkUrl());
        //设置 id
        int menuId = menuService.getOne(queryWrapper).getId();
        newFirstMenu.setId(menuId);

        //修改 角色权限 表
        RoleMenu newRoleMenu = new RoleMenu();
        newRoleMenu.setRoleId(role.getId());
        newRoleMenu.setMenuId(menuId);
        LambdaQueryWrapper<RoleMenu> roleMenuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleMenuLambdaQueryWrapper.eq(RoleMenu::getRoleId, newRoleMenu.getRoleId());
        roleMenuLambdaQueryWrapper.eq(RoleMenu::getMenuId, newRoleMenu.getMenuId());
        roleMenuService.update(newRoleMenu, roleMenuLambdaQueryWrapper);
        log.info("菜单权限对应关系表更新成功");

        if (menuService.updateById(newFirstMenu)) {
            log.info("菜单保存成功");
            return JsonVO.success("修改成功！");
        } else {
            return JsonVO.fail("修改失败", ResultStatus.FAIL);
        }

    }

    @Override
    @ApiOperation(value = "根据菜单id和商户类型删除一级菜单")
    @DeleteMapping("remove-first-menu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "一级菜单的id",example = "1"),
            @ApiImplicitParam(name = "roleName",value = "一级菜单的商户类型",example = "物业")
    })
    public JsonVO<String> removeFirstMenu(Integer id, String roleName) {
        Role role = roleService.getOne(new LambdaQueryWrapper<Role>().eq(Role::getName, roleName));
        if (role == null) {
            log.error("没有该商户");
            return JsonVO.fail("没有该商户", ResultStatus.ROLE_UN_FOUND);
        }
        Menu menu = menuService.getById(id);
        RoleMenu one = roleMenuService.getOne(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getMenuId, menu.getId()).eq(RoleMenu::getRoleId, role.getId()));

        if (roleMenuService.removeRoleMenu(one)) {
            log.info("菜单权限对应关系表删除成功");
            return JsonVO.success("删除成功！");
        } else {
            return JsonVO.fail("删除失败！", ResultStatus.FAIL);
        }
    }
}
