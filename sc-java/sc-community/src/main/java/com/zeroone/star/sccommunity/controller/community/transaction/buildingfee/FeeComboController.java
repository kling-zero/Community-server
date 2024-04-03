package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.FeeComboDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboMemberByComboIdQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboMemberVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboVO;
import com.zeroone.star.sccommunity.service.buildingfee.impl.FeeComboServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/transactions/building-fee/batch-pay-fee")
@Api(tags = "费用套餐接口")
@Validated
public class FeeComboController {
    @Resource
    FeeComboServiceImpl feeComboService;

    @GetMapping("/queryFeeComboMember")
    @ApiOperation(value = "查询费用套餐")
    public JsonVO<PageVO<FeeComboVO>> queryFeeComboMember(FeeComboQuery condition){
        return JsonVO.success(feeComboService.listAll(condition));
    }

    @GetMapping("/queryFeeComboMemberByComboId")
    @ApiOperation(value = "根据套餐ID查询套餐信息")
    public JsonVO<PageVO<FeeComboMemberVO>> queryFeeComboMemberByComboId(FeeComboMemberByComboIdQuery condition){
        return JsonVO.success(feeComboService.getById(condition));
    }

    @PostMapping("/addFeeCombo")
    @ApiOperation(value = "添加费用套餐")
    public JsonVO<String> addFeeCombo(FeeComboDTO dto){
        int flag = feeComboService.insert(dto);
        if (flag == 2) {
            return JsonVO.success(null);
        } else {
            return JsonVO.fail(null);
        }
    }
}
