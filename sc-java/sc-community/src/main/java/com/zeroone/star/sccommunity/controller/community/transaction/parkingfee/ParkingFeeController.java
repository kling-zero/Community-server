package com.zeroone.star.sccommunity.controller.community.transaction.parkingfee;

import com.zeroone.star.project.community.transactions.parkingFee.ParkingFeeApis;
import com.zeroone.star.project.dto.community.transactions.parkingfee.DeleteParkingFeeDTO;
import com.zeroone.star.project.dto.community.transactions.parkingfee.UpdateParkingFeeDTO;
import com.zeroone.star.project.query.community.transactions.parkingfee.ParkingCarQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee.ParkingCarVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */

@RestController
@RequestMapping("/parkingFee")
@Api(tags = "停车费用")
@Validated
public class ParkingFeeController implements ParkingFeeApis {

    @GetMapping("query-all")
    @ApiOperation(value = "查询所有停车费用信息")
    @Override
    public JsonVO<PageVO<ParkingCarVO>> queryAllParking(ParkingCarQuery parkingCarQuery) {
        return null;
    }

    @PostMapping(path = {"/deleteFee","/finshFee"})
    @ApiOperation("删除停车费用")
    @Override
    public JsonVO deleteOne(DeleteParkingFeeDTO data) {
        return null;
    }
    @PostMapping("/updateFee")
    @ApiOperation("变更停车费用")
    @Override
    public JsonVO updateOne(UpdateParkingFeeDTO data) {
        return null;
    }

    @PostMapping("/saveFee")
    @ApiOperation("创建停车费用")
    @Override
    public JsonVO saveOne(UpdateParkingFeeDTO data) {
        return null;
    }
}
