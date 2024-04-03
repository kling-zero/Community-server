package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import com.zeroone.star.project.query.community.transactions.buildingfee.batchpayfee.BatchPayFeeQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.PayFeeDetailQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.batchpayfee.BatchPayFeeVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/transactions/building-fee/batch-pay-fee")
@Api(tags = "批量缴费")
@Validated
public class BatchPayFeeController {
    @GetMapping("/query-batch-pay-fee")
    @ApiOperation(value = "查询批量缴费信息")
    public JsonVO<PageVO<BatchPayFeeVO>> queryBatchPayFee(BatchPayFeeQuery condition){
        return null;
    }

    @GetMapping("/query-pay-fee-detail")
    @ApiOperation(value = "列表查询展示支付服务")
    public JsonVO<List<FeeTypeCdsVO>> queryPayFeeDetail(PayFeeDetailQuery condition){
        return null;
    }
}
