package com.zeroone.star.repair.controller.queryController;

import com.zeroone.star.project.repair.demoQueryApi.RepairSettingTypeConditionApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairSettingTypeVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
public class RepairSettingTypeController implements RepairSettingTypeConditionApi {
    @GetMapping("repairSettingType")
    @ApiOperation("报修类型设置")
    @Override
    public JsonVO<RepairSettingTypeVO> repairSettingTypeList() {
        return JsonVO.success(null);
    }
}
