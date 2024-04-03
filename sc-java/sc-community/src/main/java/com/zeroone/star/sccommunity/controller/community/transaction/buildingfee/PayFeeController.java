package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.community.transactions.buildingfee.OwnerPrestoreAccountDTO;
import com.zeroone.star.project.dto.community.transactions.buildingfee.PayFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.FeePrintQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.FeeReceiptQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountCycleQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeAttrVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.payfee.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transactions/building-fee/batch-pay-fee")
@Api(tags = "缴费接口")
@Validated
public class PayFeeController {
    @GetMapping("/queryOwnerAccount")
    @ApiOperation(value = "分页查询账户信息")
    public JsonVO<PageVO<OwnerAccountVO>> queryOwnerAccount(OwnerAccountQuery condition){
        OwnerAccountVO ownerAccountVO = new OwnerAccountVO();

        ownerAccountVO.setAcctId("312022101057640102");
        ownerAccountVO.setAcctName("he71");
        ownerAccountVO.setAcctType("2003");
        ownerAccountVO.setAmount("300");
        ownerAccountVO.setCreateTime(new DateTime("2022-10-16 14:00:16"));
        ownerAccountVO.setObjId("772022101005705404");
        ownerAccountVO.setObjType("6006");
        ownerAccountVO.setPageIndex(1L);
        ownerAccountVO.setPageSize(10L);
        ownerAccountVO.setPages(100L);
        ownerAccountVO.setPartId("2022090665021542");
        ownerAccountVO.setStatusCd("0");
        ownerAccountVO.setTotal(100000L);

        ArrayList<OwnerAccountVO> list = new ArrayList<>();
        list.add(ownerAccountVO);
        Page<OwnerAccountVO> page = new Page<>();
        page.setRecords(list);
        return JsonVO.success(PageVO.create(page, OwnerAccountVO.class));
    }

    @GetMapping("/listFeeObj")
    @ApiOperation(value = "查询订单收费的对象的信息")
    public JsonVO<List<FeeObjVO>> listFeeObj(OwnerAccountQuery condition){
        FeeObjVO feeObjVO =  new FeeObjVO();
        ArrayList<FeeObjVO> list = new ArrayList<>();
        feeObjVO.setAdditionalAmount("800.00");
        feeObjVO.setAmount("-1.00");
        feeObjVO.setBId("-1");
        feeObjVO.setBatchId("122022101668807986");
        feeObjVO.setBillType("002");
        feeObjVO.setBillTypeName("每月1日");
        feeObjVO.setBuiltUpArea("124.00");
        feeObjVO.setCommunityId("2022090665021542");
        feeObjVO.setComputingFormula("2002");
        feeObjVO.setComputingFormulaText(",");
        feeObjVO.setConfigEndTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setConfigId("922022101175295767");
        feeObjVO.setConfigStartTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setCount(0);
        feeObjVO.setDeadlineTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setEndTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setFeeFlag("1003006");
        feeObjVO.setFeeFlagName("一次性费用");
        feeObjVO.setFeeId("902022101476217398");
        feeObjVO.setFeeName("物业缴费测试101");
        feeObjVO.setFeePrice(800);
        feeObjVO.setFeeTotalPrice(0);
        feeObjVO.setFeeTypeCdName("物业费");
        feeObjVO.setStartTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setSquarePrice("0");
        feeObjVO.setStateName("收费状态中");
        feeObjVO.setFeeTypeCd("888800010015");
        feeObjVO.setIncomeObjId("1020220906622991416");
        feeObjVO.setIsDefault("T");
        feeObjVO.setOfflinePayFeeSwitch("3");
        feeObjVO.setPayerObjId("752022100910441032");
        feeObjVO.setPayerObjName("1栋1单元1室");
        feeObjVO.setPayerObjType("3333");
        feeObjVO.setPaymentCd("2100");
        feeObjVO.setPaymentCycle("12");
        feeObjVO.setReceivedAmountSwitch("1");
        feeObjVO.setState("1001");
        feeObjVO.setUserId("-1");
        feeObjVO.setVal("1");
        feeObjVO.setMaxEndTime(new DateTime("2022-10-16 14:00:16"));
        feeObjVO.setOweFee(0);
        feeObjVO.setOwnerName("he71");
        feeObjVO.setStatusCd("0");
        feeObjVO.setFeeAttr(new ArrayList<>());
        list.add(feeObjVO);
        return JsonVO.success(list);
    }

    @GetMapping("/listFeePrint")
    @ApiOperation(value = "费用打印展示信息")
    public JsonVO<List<FeePrintVO>> listFeePrint(FeePrintQuery condition){
        ArrayList<FeePrintVO> list = new ArrayList<>();
        FeePrintVO feePrintVO = new FeePrintVO();
        feePrintVO.setCommunityId("2022090665021542");
        feePrintVO.setPageId("102022101350667285");
        feePrintVO.setPageName("ont1");
        feePrintVO.setPageUrl("4");
        feePrintVO.setState("T");
        feePrintVO.setStatusCd("0");
        feePrintVO.setTemplateName("祥云物流园区");
        feePrintVO.setUrl("/print.html#/pages/property/printPayFeeXiangyun");
        list.add(feePrintVO);
        return JsonVO.success(list);
    }

    @GetMapping("/listFeeObjByCycle")
    @ApiOperation(value = "根据周期查询订单收费对象的信息")
    public JsonVO<List<FeeObjCycleVO>> listFeeObjByCycle(OwnerAccountCycleQuery condition){
        ArrayList<FeeObjCycleVO> list = new ArrayList<>();
        FeeObjCycleVO feeObjCycleVO = new FeeObjCycleVO();
        feeObjCycleVO.setCurDegrees("0.00");
        feeObjCycleVO.setCurReadingTime(new DateTime("2022-10-16 14:00:16"));
        feeObjCycleVO.setCycle("12");
        list.add(feeObjCycleVO);
        return JsonVO.success(list);
    }

    @GetMapping("/queryFeeReceipt")
    @ApiOperation(value = "查询费用收据")
    public JsonVO<FeeReceiptVO> queryFeeReceipt(FeeReceiptQuery condition){
        FeeReceiptVO feeReceiptVO = new FeeReceiptVO();
        feeReceiptVO.setAmount("-1.00");
        feeReceiptVO.setCommunityId("2022090665021542");
        feeReceiptVO.setFeeName("物业缴费测试101");
        feeReceiptVO.setFeeTypeCd("888800010015");
        feeReceiptVO.setStatusCd("0");
        feeReceiptVO.setCarNum("-");
        feeReceiptVO.setCreateTime(new DateTime("2022-10-16 14:00:16"));
        feeReceiptVO.setObjId("772022101005705404");
        feeReceiptVO.setObjName("1-1-1");
        feeReceiptVO.setObjType("3333");
        feeReceiptVO.setPayObjId("772022101005705404");
        feeReceiptVO.setPayObjName("he71");
        feeReceiptVO.setReceiptId("832022101604427609");
        feeReceiptVO.setRoomName("1-1-1");
        feeReceiptVO.setStoreName("演示物业");
        return JsonVO.success(feeReceiptVO);
    }

    @PostMapping("/payFeeJson")
    @ApiOperation(value = "缴费")
    public JsonVO<PayFeeVO> payFeeJson(PayFeeDTO dto){
        PayFeeVO payFeeVO = new PayFeeVO();
        payFeeVO.setDetailId("800");
        payFeeVO.setStatusCd("0");
        return JsonVO.success(payFeeVO);
    }

    @PostMapping("/modifyOwnerPretoreAccount")
    @ApiOperation(value = "预存账户金额")
    public JsonVO<String> modifyOwnerPretoreAccount(OwnerPrestoreAccountDTO dto){
        return JsonVO.success("success");
    }
}
