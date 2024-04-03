package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.dto.setting.ModifyPasswordDTO;
import com.zeroone.star.project.setting.ModifyPasswordApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scsetting.service.ModifyPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting.controller
 * @Author: sensfloron
 * @CreateTime: 2022-10-14  22:05
 * @Description: TODO 人员信息管理
 * @Version: 1.0
 */
@RestController
@RequestMapping("/modify")
@Api(tags = "修改密码")
public class ModifyPasswordController implements ModifyPasswordApis {


    //@Autowired
    @Resource
    ModifyPasswordService service;


    @Override
    @ApiOperation(value = "修改密码")
    @PostMapping("/password")
    public JsonVO<Integer> modifyUserPassword(
            @RequestBody ModifyPasswordDTO modifyPasswordDTO) {
//        int res = service.ModifyPassword(modifyPasswordDTO.getId(), modifyPasswordDTO.getPasswordNew(), modifyPasswordDTO.getPasswordOld());
//        if (res == 0) {
//            return JsonVO.create(null, ResultStatus.SUCCESS_UPDATE_PASSWORD);
//        } else if (res == 1) {
//            return JsonVO.create(null, ResultStatus.ERROR_OLD_PASSWORD);
//        } else {
//            return JsonVO.create(null, ResultStatus.FAIL_UPDATE_PASSWORD);
//        }
        return null;
    }
}
