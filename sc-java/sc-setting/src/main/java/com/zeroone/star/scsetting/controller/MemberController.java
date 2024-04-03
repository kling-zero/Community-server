package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.dto.setting.MemberInfoDto;
import com.zeroone.star.project.query.setting.MemberQuery;
import com.zeroone.star.project.setting.MemberInfoApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.setting.MemberFullInfoVo;
import com.zeroone.star.project.vo.setting.MemberSimpleInfoVo;
import com.zeroone.star.scsetting.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting.controller
 * @Author: sensfloron
 * @CreateTime: 2022-10-14  22:05
 * @Description: TODO 人员信息管理
 * @Version: 1.0
 */
@RestController
@RequestMapping("/members")
@Api(value = "组织设置 员工信息管理")
public class MemberController implements MemberInfoApis {
    @Autowired
    MemberService memberService;

    /**
     * @Description 查询员工信息列表
     * @Param
     * @Return
     */
    @ApiOperation(value = "查询员工信息列表")
    @GetMapping("/getMemberInfoList")
    @Override
    public JsonVO<PageVO<MemberSimpleInfoVo>> getMemberInfoList(MemberQuery memberQuery) {
        try {
            PageVO<MemberSimpleInfoVo> infoList = memberService.getInfoList(memberQuery);
            return JsonVO.create(infoList, ResultStatus.SUCCESS);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL);
        }
    }

    /**
     * @Description 获取员工的完整信息
     * @Param
     * @Return
     */
    @ApiOperation(value = "获取员工的完整信息")
    @GetMapping("/getMemberFullInfo")
    @Override
    public JsonVO<MemberFullInfoVo> getMemberFullInfo(
            @RequestParam(value = "员工id", required = true)
            @RequestBody Long id) {
        try {
            MemberFullInfoVo memberFullInfo = memberService.getMemberFullInfo(id);
            return JsonVO.create(memberFullInfo, ResultStatus.SUCCESS);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL);
        }
    }

    @ApiOperation(value = "添加员工信息")
    @PostMapping("/addMemberInfo")
    @Override
    public JsonVO<String> addMemberInfo(MemberInfoDto memberInfoDto) {
        try {
            memberService.addMemberInfo(memberInfoDto);
            return JsonVO.create(null, ResultStatus.SUCCESS);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL);
        }
    }

    @ApiOperation(value = "删除员工信息")
    @DeleteMapping("/deleteMemberInfo")
    @Override
    public JsonVO<String> deleteMemberInfo(
            @RequestParam(value = "员工id", required = true)
            @RequestBody Long id) {
        try {
            memberService.deleteMemberInfo(id);
            return JsonVO.create(null, ResultStatus.SUCCESS);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL);
        }
    }



    @ApiOperation(value = "重置员工密码为随机六位数")
    @PutMapping("/resetPassword")
    @Override
    public JsonVO<String> resetPassword(
            @RequestParam(value = "员工id", required = true)
            @RequestBody Long id) {
        try {
            String password = memberService.resetPassword(id);
            return JsonVO.create(password, ResultStatus.SUCCESS);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL);
        }
    }
}
