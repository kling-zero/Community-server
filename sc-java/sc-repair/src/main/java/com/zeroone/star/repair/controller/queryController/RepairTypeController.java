package com.zeroone.star.repair.controller.queryController;

import com.zeroone.star.project.repair.demoQueryApi.RepairTypeConditionApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairTypeVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
public class RepairTypeController implements RepairTypeConditionApi {

    @GetMapping("repairType")
    @ApiOperation("报修类型")
    @Override
    public JsonVO<RepairTypeVO> repairTypeList() {
        return JsonVO.success(null);
    }
}
