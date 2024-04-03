package com.zeroone.star.scstore.controller;


import com.zeroone.star.project.query.store.CommunityQuery;
import com.zeroone.star.project.query.store.StoreAdminQuery;
import com.zeroone.star.project.query.store.StoreQuery;
import com.zeroone.star.project.store.StoreApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.store.CommunitiesVO;
import com.zeroone.star.project.vo.store.StoreAdminVO;
import com.zeroone.star.project.vo.store.StoreVO;
import com.zeroone.star.scstore.service.IStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author night
 * @since 2022-10-16
 */
@RestController
@RequestMapping("/store")
@Api(tags = "商户管理")
@Validated
public class StoreController implements StoreApis {

    @Autowired
    IStoreService iStoreService;

    @GetMapping("getAllStoreTypes")
    @ApiOperation(value = "获取所有商户类型")
    @Override
    public JsonVO<List<String>> getAllStoreTypes() {
        List<String> list = iStoreService.getAllTypes();
        return JsonVO.success(list);
    }

    @GetMapping("getStores")
    @ApiOperation(value = "根据条件和页数获取所有商户信息")
    @Override
    public JsonVO<PageVO<StoreVO>> getStoresByPageAndCondition(StoreQuery storeQuery) {
        PageVO<StoreVO> stores = iStoreService.getStores(storeQuery);
        return JsonVO.success(stores);
    }

    @GetMapping("getAllAdmins")
    @ApiOperation(value = "根据条件和页数获取所有商户管理员信息")
    @Override
    public JsonVO<PageVO<StoreAdminVO>> getStoreAdminsByPageAndCondition(StoreAdminQuery storeAdminQuery) {
        PageVO<StoreAdminVO> admins = iStoreService.getStoreAdminByPageAndCondition(storeAdminQuery);
        return JsonVO.success(admins);
    }

    @GetMapping("queryAllSubCommunities")
    @ApiOperation(value = "获取符合条件的指定ID物业的所有隶属小区")
    @Override
    public JsonVO<PageVO<CommunitiesVO>> queryAllSubordinationCommunities(CommunityQuery communityQuery) {
        PageVO<CommunitiesVO> communities = iStoreService.getSubordinations(communityQuery);
        return JsonVO.success(communities);
    }

    @PostMapping("modifyRestrict")
    @ApiOperation(value = "限制/解除限制登录指定ID物业")
    @Override
    public JsonVO<String> modifyRestrictLoginById(String id) {
        iStoreService.modifyState(id);
        return JsonVO.success("操作成功");
    }
}

