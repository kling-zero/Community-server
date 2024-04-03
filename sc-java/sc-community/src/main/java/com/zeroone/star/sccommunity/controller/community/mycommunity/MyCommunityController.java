package com.zeroone.star.sccommunity.controller.community.mycommunity;

import com.zeroone.star.project.dto.community.myCommunity.MyCommunityDTO;
import com.zeroone.star.project.community.myCommunity.MyCommunityApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.myCommunity.MyCommunityVO;
import com.zeroone.star.sccommunity.service.carinfo.IBuildingOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

@RestController
@RequestMapping("/communitys")
@Api(tags = "入驻小区查询")
@Validated
public class MyCommunityController implements MyCommunityApis {
    @Autowired
    private IBuildingOwnerService buildingOwnerService;

    @GetMapping("/queryStoreCommunitys")
    @ApiOperation(value = "查询所有已入驻小区")
    @Override
    public JsonVO<PageVO<MyCommunityVO>> queryAll(int condition) {
        return null;
    }

    @PutMapping("/updateStoreCommunity")
    @Override
    public JsonVO<PageVO<MyCommunityVO>> updataDate(MyCommunityDTO condition) {
        return null;
    }

    @GetMapping("/getCommunityId")
    public JsonVO<String> queryCommunityId(String userId) {
        String communityId = buildingOwnerService.getCommunityId(userId);
        return JsonVO.success(communityId);
    }

}
