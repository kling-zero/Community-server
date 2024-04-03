package com.zeroone.star.schp.controller;

import com.zeroone.star.project.homepage.HomePageApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.homepage.*;
import com.zeroone.star.schp.service.INNoticeService;
import com.zeroone.star.schp.service.ComplaintService;
import com.zeroone.star.schp.service.CommunityInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RequestMapping("/hp")
@Api(tags = "首页")
@Validated
public class HpController implements HomePageApis {
    @Resource
    CommunityInfoService communityInfoService;

    @Autowired
    private ComplaintService complaintService;

    @Resource
    private INNoticeService inNoticeService;

    @GetMapping("getCommunityInfo")
    @ApiOperation(value = "获取首页-小区信息")
    @Override
    public JsonVO<CommunityVO> getCommunityInfo(@RequestParam String communityId) {
        return JsonVO.success(communityInfoService.listAllCommunityInfo(communityId));
    }

    @GetMapping("getBulletin")
    @ApiOperation(value = "获取首页-小区公告")
    @Override
    public JsonVO<List<NoticeVO>> getBulletin(String communityId) {
        return JsonVO.success(inNoticeService.getBulletin(communityId));
    }

    @GetMapping("getRepairCount")
    @ApiOperation(value = "获取首页-报修统计")
    @Override
    public JsonVO<RepairCountVO> getRepairCount(String communityId) {
        RepairCountVO repairCountVO = new RepairCountVO();
        repairCountVO.setHandled(1);
        repairCountVO.setInProcess(1);
        repairCountVO.setTotal(1);
        repairCountVO.setStandby(1);
        return JsonVO.success(repairCountVO);
    }

    @GetMapping("getComplaintCount")
    @ApiOperation(value = "获取首页-投诉统计")
    @Override
    public JsonVO<ComplaintCountVO> getComplaintCount(String communityId) {

        return complaintService.getComplaintCount();
    }

    @GetMapping("getRegisterCount")
    @ApiOperation(value = "获取首页-住户注册统计")
    @Override
    public JsonVO<RegisterCountVO> getRegisterCount(String communityId) {
        RegisterCountVO registerCountVO = new RegisterCountVO();
        registerCountVO.setRegistered(1);
        registerCountVO.setBound(5);
        registerCountVO.setUnBound(2);
        registerCountVO.setUnregistered(2);
        return JsonVO.success(registerCountVO);
    }
}
