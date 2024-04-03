package com.zeroone.star.sccommunity.controller.community.propertyrightregistration;

import com.zeroone.star.project.community.propertyrightregistration.PRRApis;
import com.zeroone.star.project.dto.community.propertyrightregistration.*;

import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.community.propertyrightregistration.CheckVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;
import com.zeroone.star.sccommunity.service.prrmanagement.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("propertyRightRegistration")
@Api(tags = "产权登记")
@Validated
public class PRRController implements PRRApis{

    @Autowired
    IPRRService prrService;

    @Autowired
    ISavePRRService savePRRService;

    @Autowired
    IUpdatePPRlService updatePPRlService;

    @Autowired
    IPRRDetailService prrDetailService;

    @Autowired
    IUpdatePPRDetailService updatePPRDetailService;
    @Autowired
    ICheckService checkService;



    @GetMapping("listPropertyRightRegistration")
    @ApiOperation(value = "查询所有产权基本信息")
    public JsonVO<PageVO<PRRVO>> queryProperty(PRRQuery condition){
        return JsonVO.success(prrService.queryAll(condition));
    }

    @GetMapping("listPropertyRightRegistrationDetail")
    @ApiOperation(value = "查询产权详细详细信息")
    public JsonVO<PageVO<PRRDetailVO>> queryPropertyDetail(PRRDetailQuery condition){
        return JsonVO.success(prrDetailService.queryDetailById(condition));
    }


    @PostMapping("delete-Property")
    @ApiOperation(value = "删除房屋产权信息")
    public JsonVO<String> deleteProperty(DeletePPRDTO condition){
        if (!StringUtils.isEmpty(condition)) {
            if (prrService.deletePPR(condition)==1) {
                return JsonVO.create(null,ResultStatus.SUCCESS);
            } else {
                return JsonVO.create(null, ResultStatus.FAIL);
            }
        }else {
            return JsonVO.fail(condition.toString());
        }
    }

    @PostMapping("update-Property")
    @ApiOperation(value = "修改房屋产权基本信息")
    public JsonVO<String> updateProperty(UpdatePPRlDTO condition) {
        if (!StringUtils.isEmpty(condition)) {
            updatePPRlService.updatePRRl(condition);
            return JsonVO.create(condition.toString(), ResultStatus.SUCCESS);
        }else {
            return JsonVO.fail(condition.toString());
        }
    }

    @PostMapping("update-Property-Detail")
    @ApiOperation(value = "修改房屋产权详细信息")
    public JsonVO<String> updatePropertyDetail(UpdatePPRDetailDTO condition){
        if (!StringUtils.isEmpty(condition)) {
            updatePPRDetailService.updateDetail(condition);
            return JsonVO.create(condition.toString(), ResultStatus.SUCCESS);
        }else {
            return JsonVO.fail(condition.toString());
        }
    }



    @PostMapping("add-Property")
    @ApiOperation(value = "添加房屋产权信息")
    public JsonVO<String> saveProperty(SavePRRDTO condition){
        if (savePRRService.save(condition)){
            return JsonVO.create(condition.toString(), ResultStatus.SUCCESS);
        }else {
            return JsonVO.create(condition.toString(), ResultStatus.FAIL);
        }
    }

    @PostMapping("check-Property")
    @ApiOperation("审核房屋产权")
    public JsonVO<CheckVO> checkProperty(CheckDTO condition) {
        if (!StringUtils.isEmpty(condition)){
            return JsonVO.create(checkService.checkDTO(condition),ResultStatus.SUCCESS);
        }else
            return JsonVO.fail(null);
    }

}
