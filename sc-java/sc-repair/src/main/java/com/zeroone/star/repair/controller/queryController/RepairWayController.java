package com.zeroone.star.repair.controller.queryController;


import com.zeroone.star.project.repair.demoQueryApi.RepairWayConditionApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.repair.RepairWayVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/repair")
public class RepairWayController implements RepairWayConditionApi {

    @GetMapping("repairWay")
    @ApiOperation("派单方式")
    @Override
    public JsonVO<RepairWayVo> repairWayList() {
        return JsonVO.success(null);
    }
}
