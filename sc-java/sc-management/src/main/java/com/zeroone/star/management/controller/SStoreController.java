package com.zeroone.star.management.controller;

import com.zeroone.star.management.service.ISCommunityService;
import com.zeroone.star.management.service.ISStoreService;
import cn.hutool.core.util.StrUtil;
import com.zeroone.star.management.entity.*;
import com.zeroone.star.management.service.*;
import com.zeroone.star.management.service.ISCommunityMemberService;
import com.zeroone.star.management.service.ISMenuGroupCommunityService;
import com.zeroone.star.project.dto.management.PropertyDTO;
import com.zeroone.star.project.dto.management.PropertyStateDTO;
import com.zeroone.star.project.dto.management.UpdatePropertyDTO;
import com.zeroone.star.project.management.PropertyApi;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.PropertyVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zeroone.star.management.service.impl.SStoreServiceImpl.getDateRandomCode;

/**
 * @Author: j4
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 8:35
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/management/s-store")
@Api(tags = "物业数据管理")
@Validated
public class SStoreController implements PropertyApi {

    @Autowired
    ISCommunityService communityService;
    @Autowired
    ISStoreService storeService;
    @Resource
    IMMenuGroupCommunityService imMenuGroupCommunityService;
    @Resource
    ISStoreAttrService isStoreAttrService;
    @Resource
    ISpecService iSpecService;
    @Resource
    ISCommunityMemberService isCommunityMemberService;
    @Resource
    IMMenuGroupService imMenuGroupService;
    @Autowired
    ISMenuGroupCommunityService isMenuGroupCommunityService;

    @GetMapping("list-Property")
    @ApiOperation(value = "查询物业")
    @Override
    public JsonVO<PageVO<PropertyVO>> queryByCondition(PropertyQuery condition) {
        return JsonVO.success(storeService.listPropertyByCondition(condition));
    }

    @GetMapping("query-BelongingCommunities")
    @ApiOperation(value = "查询某物业所管理的小区列表")
    @Override
    public JsonVO<PageVO<SCommunityVO>> queryBelongingCommunities(CommunityQuery communityQuery) {
        if (communityQuery.getStoreId()==null){
            return JsonVO.fail(null);
        }
        return JsonVO.success(storeService.queryBelongingCommunities(communityQuery));
    }

    @PutMapping("insert-property")
    @ApiOperation(value = "添加物业")
    @Override
    public JsonVO<String> insertProperty(@Validated PropertyDTO propertyDTO) {
        int insert = storeService.insertProperty(propertyDTO);
        if (insert<1) return JsonVO.fail("添加失败");

        return JsonVO.success("添加成功");

//        //填加物业信息S_Store_Service
//        int i = storeService.insertProperty(propertyDTO);
//        //遍历 物业 和 功能信息 添加每一个 组合进 M_Menu_Group_Community_Service
//        for(String gId:propertyDTO.getCommunityIds()){
//            for(String id:propertyDTO.getGroupIds()){
//                SCommunity community = communityService.getCommunityByName(gId);
//                MMenuGroup menuGroup = imMenuGroupService.getMMenuGroupByName(id);
//                imMenuGroupCommunityService.insertMMenuGroupCommunity(gId,id,community,menuGroup);
//            }
//            //将每一个小区信息 添加进 s_Community_Member_service
//            SCommunity communityByName = communityService.getCommunityByName(gId);
//            isCommunityMemberService.insertISCommunityMemberService(communityByName,propertyDTO.getMemberId());
//        }
//        //获得企业法人属性信息，添加法人信息进S_Store_Attr
//        Spec spec = iSpecService.getSpecByName("企业法人");
//        isStoreAttrService.insertSStoreAttr(spec,propertyDTO.getCorporation(),propertyDTO.getStoreId());
    }

    @PostMapping("update-Property")
    @ApiOperation(value = "修改物业")
    @Override
    public JsonVO<String> updatePropertyByID(@Validated UpdatePropertyDTO updatepropertyDTO) {
        //更新物业信息
        int i = storeService.updatePropertyByID(updatepropertyDTO);
        String corName = updatepropertyDTO.getCorporation();
        //通过物业id更改企业法人信息
        int j = isStoreAttrService.updateSStroeAttrValueById(updatepropertyDTO.getStoreId(), corName);
        if (i != 0 && j != 0)
            return JsonVO.success("修改成功");
        else
            return JsonVO.fail("添加失败");
    }

    @DeleteMapping("removeProperty")
    @ApiOperation(value = "删除物业公司")
    @Override
    public JsonVO<String> removeById(String storeId){
        boolean flag = storeService.removePropertyById(storeId);
        return flag ? JsonVO.success("删除物业成功！") : JsonVO.fail("删除物业失败！");
    }

    @PutMapping("update-restrict-login")
    @ApiOperation(value = "限制物业登录")
    @Override
    public JsonVO<String> updateRestrictLogin( @RequestBody PropertyStateDTO propertyStateDTO) {
        if (propertyStateDTO == null){
            return JsonVO.fail("传输数据对象为空！");
        }
        boolean flag = storeService.updateState(propertyStateDTO);
        return flag ? JsonVO.success("修改限制登录状态成功！") : JsonVO.fail("修改限制登录状态失败！");
    }

    @PostMapping("reset-pwd")
    @ApiOperation(value = "重置物业公司密码")
    @Override
    public JsonVO<PropertyVO> resetPwd(PropertyDTO propertyDTO) {
        String s = storeService.randomUpdatePwd(propertyDTO);
        if(StrUtil.hasBlank(s)){
            return JsonVO.fail(null);
        }
        PropertyVO propertyVO = new PropertyVO();
        propertyVO.setPassword(s);
        return JsonVO.success(propertyVO);
    }

    @PutMapping ("add-community")
    @ApiOperation(value = "物业公司添加小区")
    @Override
    public JsonVO<String> propertyInsertCommunity(PropertyDTO propertyDTO) {
        String s = storeService.saveCommunity(propertyDTO);
        if(StrUtil.hasBlank(s)){
            return JsonVO.fail("添加失败");
        }
        return JsonVO.success("添加成功");
    }

    @ApiOperation("修改小区功能")
    @PostMapping("update-menu")
    @Override
    public JsonVO<String> updateMenu( PropertyDTO propertyDTO){
        boolean flag = isMenuGroupCommunityService.updateMenu(propertyDTO);
        return flag ? JsonVO.success("修改菜单成功！") : JsonVO.fail("修改菜单失败！");
    }

    @ApiOperation("退出小区")
    @PostMapping("quit-community")
    @Override
    public JsonVO<String> quitCommunity(CommunityQuery communityQuery){
        boolean flag =isCommunityMemberService.removeCommunity(communityQuery);
        return flag ? JsonVO.success("修改菜单成功！") : JsonVO.fail("修改菜单失败！");
    }

    @GetMapping("query-AccessibleCommunities")
    @ApiOperation(value = "可加入小区回显")
    @Override
    public JsonVO<List<SCommunityVO>> queryAccessibleCommunities() {
        return JsonVO.success(communityService.selectNoEnterCommunity());
    }
}