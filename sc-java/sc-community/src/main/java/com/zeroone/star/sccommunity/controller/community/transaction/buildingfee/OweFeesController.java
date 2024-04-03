package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.PayOweFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.owefees.OweFeesQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.owefees.OweFeesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions/building-fee/oweFees")
@Api(tags = "欠费缴费")
@Validated
public class OweFeesController {
    @GetMapping("/queryOweFees")
    @ApiOperation(value = "查询欠费数据")
    public JsonVO<PageVO<OweFeesVO>> queryOweFees(OweFeesQuery condition){
        return null;
    }

    @PostMapping("/payOweFeeJson")
    @ApiOperation(value = "缴费")
    public JsonVO<String> payOweFeeJson(PayOweFeeDTO dto){
        return null;
    }
}
