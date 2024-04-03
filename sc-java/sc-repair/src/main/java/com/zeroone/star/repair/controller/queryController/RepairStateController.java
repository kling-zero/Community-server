package com.zeroone.star.repair.controller.queryController;

import com.zeroone.star.project.repair.demoQueryApi.RepairStateConditionApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairStateVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
public class RepairStateController implements RepairStateConditionApi {

    @GetMapping("repairState")
    @ApiOperation("报修状态")
    @Override
    public JsonVO<RepairStateVO> repairStateList() {
        return JsonVO.success(null);
    }
}
