package com.zeroone.star.management.controller;


import com.zeroone.star.management.entity.MMenu;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.zeroone.star.management.service.IMMenuGroupService;
import com.zeroone.star.management.service.ISCommunityService;
import com.zeroone.star.management.service.ISMenuGroupCommunityService;
import com.zeroone.star.management.service.ISMenuService;
import com.zeroone.star.project.dto.management.CommunityDTO;
import com.zeroone.star.project.dto.management.ModifyCommunityDTO;
import com.zeroone.star.project.management.CommunityApi;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.CityAreaVO;
import com.zeroone.star.project.vo.management.SCommunityMenuVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author j4
 * @since 2022-10-08
 */
@RestController
@RequestMapping("/management/s-community")
@Api(tags = "小区数据管理")
public class SCommunityController implements CommunityApi {

    @Resource
    ISCommunityService communityService;
    @Resource
    ISMenuService isMenuService;
    @Resource
    ISMenuGroupCommunityService isMenuGroupCommunityService;
    @Autowired
    IMMenuGroupService imMenuGroupService;

    @GetMapping("list-community")
    @ApiOperation(value = "查询小区")
    @Override
    public JsonVO<PageVO<SCommunityVO>> queryByCondition(CommunityQuery condition) {
        return JsonVO.success(communityService.listByCondition(condition));
    }

    @PutMapping("add-community")
    @ApiOperation(value = "添加小区")
    @Override
    public JsonVO<String> addCommunity(CommunityDTO communityDTO) {
        if (communityDTO == null) {
            return JsonVO.fail("添加失败，传入数据为null");
        }

        boolean flag = communityService.saveCommunity(communityDTO);
        return flag ? JsonVO.success("添加成功") : JsonVO.fail("添加失败");
    }

    @PostMapping("modify-by-id")
    @ApiOperation(value = "修改小区信息")
    @Override
    public JsonVO<String> modifyCommunityById(ModifyCommunityDTO modifyCommunityDTO) {
        if (modifyCommunityDTO == null) {
            return JsonVO.fail("修改失败，传入对象为null");
        }

        boolean flag = communityService.updateCommunity(modifyCommunityDTO);
        return flag ? JsonVO.success("修改成功") : JsonVO.fail("修改失败");
    }

    @GetMapping("list-MenuGroup")
    @ApiOperation(value ="获取小区功能的所有可选项")
    @Override
    public JsonVO<List<SCommunityMenuVO>> listMenuGroup(){
        List<MMenuGroup> menus = imMenuGroupService.getALlMenu();
        List<SCommunityMenuVO> menuVOS = new LinkedList<>();
        //获得结果重新封装
        for (MMenuGroup menu:menus) {
            SCommunityMenuVO menuVO = new SCommunityMenuVO();
            menuVO.setMenuGroupId(menu.getGId());
            menuVO.setMenuGroupName(menu.getName());
            menuVOS.add(menuVO);
        }
        return JsonVO.success(menuVOS);
    }

    @GetMapping("list-CommunityMenu")
    @ApiOperation(value ="获取小区的已选功能")
    @Override
    public JsonVO<List<SCommunityMenuVO>> listCommunityMenu(CommunityQuery communityQuery){
        String communityId = communityQuery.getCommunityId();
        //获得结果重新封装
        List<MMenuGroupCommunity> listMenuById = isMenuGroupCommunityService.getListMenuById(communityId);
        List<SCommunityMenuVO> menuVOS = new LinkedList<>();
        for (MMenuGroupCommunity mmenu: listMenuById) {
            SCommunityMenuVO menuVO = new SCommunityMenuVO();
            menuVO.setCommunityId(mmenu.getCommunityId());
            menuVO.setCommunityName(mmenu.getCommunityName());
            menuVO.setMenuName(mmenu.getName());
            menuVO.setGroupCommunityId(mmenu.getGId());
            menuVOS.add(menuVO);
        }
        return JsonVO.success(menuVOS);
    }


}

