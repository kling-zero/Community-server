package com.zeroone.star.reportmanagement.controller;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.reportmanagement.DeadLineFeeQuery;
import com.zeroone.star.project.query.reportmanagement.LoadConditionQuery;
import com.zeroone.star.project.query.reportmanagement.LoadDictQuery;
import com.zeroone.star.project.query.reportmanagement.PayFeeDetailQuery;
import com.zeroone.star.project.reportmanagement.PayFeeDetailApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiemo
 * @date: 2022/10/25 20:42
 * @description:
 */
@RestController
@RequestMapping("/reportmanagement/pay-fee-detail")
@Api(tags = "缴费表相关")
public class PayFeeDeatilController implements PayFeeDetailApi {
    @Override
    @GetMapping("query-pay-fee-detail")
    @ApiOperation(value = "分页查询缴费明细")
    public JsonVO<PageVO<PayFeeDetailVO>> queryPayFeeDetail(PayFeeDetailQuery payFeeDetailQuery) {
        return null;
    }

    @Override
    @GetMapping("query-deanline-fee")
    @ApiOperation(value = "分页查询费用到期提醒")
    public JsonVO<PageVO<DeanlineFeeVO>> queryDeadlineFee(DeadLineFeeQuery deadLineFeeQuery) {
        return null;
    }

    @Override
    @GetMapping("query-prepayment")
    @ApiOperation(value = "分页查询预交费提醒")
    public JsonVO<PageVO<PrepaymentVO>> queryPrepayment(PageQuery pageQuery) {
        return null;
    }

    @Override
    @GetMapping("query-load-floors")
    @ApiOperation(value = "分页根据小区id查询楼房")
    public JsonVO<PageVO<LoadFloorsVO>> queryFloorsByCommunityId(LoadConditionQuery loadConditionQuery) {
        return null;
    }

    @Override
    @GetMapping("query-load-units")
    @ApiOperation(value = "分页根据楼房号查询单元")
    public JsonVO<PageVO<LoadUnitsVO>> queryUnitsByFloorId(LoadConditionQuery loadConditionQuery) {
        return null;
    }

    @Override
    @GetMapping("query-load-pay-fee-config")
    @ApiOperation(value = "分页根据费用类型查询费用项")
    public JsonVO<PageVO<LoadPayFeeConfigVO>> queryPayFeeConfigByFeeTypeCd(LoadConditionQuery loadConditionQuery) {
        return null;
    }

    @Override
    @GetMapping("query-dict")
    @ApiOperation(value = "查询字典")
    public JsonVO<LoadDictVO> queryDictByTableColumns(LoadDictQuery loadDictQuery) {
        return null;
    }
}
