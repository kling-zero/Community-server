package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeAttrVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.*;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeAttr;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.mapper.buildingfee.FeeMapper;
import com.zeroone.star.sccommunity.service.buildingfee.*;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:业峰 查询费用信息
 */
@Service
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fees> implements IFeeService {
    @Autowired
    FeeMapper feeMapper;
    @Autowired
    IPayFeeConfigService payFeeConfigService;
    @Autowired
    IPayFeeConfigDiscountService payFeeConfigDiscountService;
    @Autowired
    IBusinessMeterWaterService businessMeterWaterService;
    @Autowired
    IReportOweFeeService reportOweFeeService;
    @Autowired
    IFeeAttrService feeAttrService;
    @Autowired
    ITDictService itDictService;
    @Autowired
    IBusinessCommunityService businessCommunityService;

    @Override
    public FeesVO selectOne(OwnerAccountQuery condition) {
        QueryWrapper<Fees> wrapper = new QueryWrapper<>();
        wrapper.eq("fee_id", condition.getFeeId())
                .eq("community_id", condition.getCommunityId());
        Fees fees = feeMapper.selectOne(wrapper);
        //拷贝
        FeesVO feesVO = new FeesVO();
        BeanUtils.copyProperties(fees, feesVO);
        //封装其他属性
        //1.封装pay_fee_config属性
        PayFeeConfig payFeeConfig = payFeeConfigService.selectByConfigId(feesVO.getConfigId());
        if (payFeeConfig != null) {
            feesVO.setFeeName(payFeeConfig.getFeeName());
            feesVO.setSquarePrice(payFeeConfig.getSquarePrice());
            feesVO.setAdditionalAmount(payFeeConfig.getAdditionalAmount());
            feesVO.setComputingFormula(payFeeConfig.getComputingFormula());
            feesVO.setPaymentCycle(payFeeConfig.getPaymentCycle());
            feesVO.setPaymentCd(payFeeConfig.getPaymentCd());
            feesVO.setIsDefault(payFeeConfig.getIsDefault());
        } else {
            feesVO.setFeeName("");
            feesVO.setSquarePrice(null);
            feesVO.setAdditionalAmount(null);
            feesVO.setComputingFormula("");
            feesVO.setPaymentCycle("");
            feesVO.setPaymentCd("");
            feesVO.setIsDefault("");
        }
        //2.封装pay_fee_config_discount
        PayFeeConfigDiscount payFeeConfigDiscount = payFeeConfigDiscountService.selectByConfigId(feesVO.getConfigId());
        if (payFeeConfigDiscount != null) {
            feesVO.setMaxEndTime(payFeeConfigDiscount.getPaymaxEndTime());
        } else {
            feesVO.setMaxEndTime(null);
        }
        BusinessMeterWater businessMeterWater = businessMeterWaterService.selectByFeeId(feesVO.getFeeId());
        System.out.println(businessMeterWater);
        if (businessMeterWater != null) {
            feesVO.setPreDegrees(businessMeterWater.getPreDegrees());
            feesVO.setCurDegrees(businessMeterWater.getCurDegrees());
            feesVO.setCurReadingTime(businessMeterWater.getCurReadingTime());
            feesVO.setMwPrice(businessMeterWater.getMwPrice());
            feesVO.setPreReadingTime(businessMeterWater.getPreReadingTime());
        } else {
            feesVO.setPreDegrees("");
            feesVO.setCurDegrees("");
            feesVO.setCurReadingTime(null);
            feesVO.setMwPrice("");
            feesVO.setPreReadingTime(null);
        }
        //封装report_owe_fee
        ReportOweFee reportOweFee = reportOweFeeService.selectByFeeId(feesVO.getFeeId());
        if (reportOweFee != null) {
            feesVO.setAmountOwed(reportOweFee.getAmountOwed());
            feesVO.setDeadlineTime(reportOweFee.getDeadlineTime());
            feesVO.setPayerObjName(reportOweFee.getPayerObjName());
        } else {
            feesVO.setAmountOwed("");
            feesVO.setDeadlineTime(null);
            feesVO.setPayerObjName("");
        }
        //封装FeeAttrVO
        ArrayList<FeeAttrVO> feeAttrVOS = new ArrayList<>();
        List<FeeAttr> feeAttrs = feeAttrService.selectByFeeId(feesVO.getFeeId());
        for (FeeAttr fee : feeAttrs) {
            FeeAttrVO feeAttrVO = new FeeAttrVO();
            BeanUtils.copyProperties(fee, feeAttrVO);
            //状态码转换
            //StatusCd
            TDict tDict8 = itDictService.selectByStatus(feeAttrVO.getStatusCd(), "all", "status_cd");
            if (tDict8 != null) feeAttrVO.setStatusCd(tDict8.getName());
            //spec_cd
            TDict tDict9 = itDictService.selectByStatus(feeAttrVO.getSpecCd(), "pay_fee_attrs", "spec_cd");
            if (tDict9 != null) feeAttrVO.setSpecCd(tDict9.getName());
            feeAttrVOS.add(feeAttrVO);
        }
        if (feeAttrVOS != null) {
            feesVO.setFeeAttrs(feeAttrVOS);
        } else {
            feesVO.setFeeAttrs(null);
        }
        //封装name
        //1.fee_type_cd_name
        TDict tDict1 = itDictService.selectByStatus(feesVO.getFeeTypeCd(), "pay_fee_config", "fee_type_cd");
        if (tDict1 != null) {
            feesVO.setFeeTypeCdName(tDict1.getName());
        } else {
            feesVO.setFeeTypeCdName("");
        }
        //2.fee_flag_name
        TDict tDict2 = itDictService.selectByStatus(feesVO.getFeeFlag(), "pay_fee", "fee_flag");
        if (tDict2 != null) {
            feesVO.setFeeFlagName(tDict2.getName());
        } else {
            feesVO.setFeeFlagName("");
        }
        //3.state_name
        TDict tDict3 = itDictService.selectByStatus(feesVO.getState(), "pay_fee", "state");
        if (tDict3 != null) {
            feesVO.setStateName(tDict3.getName());
        } else {
            feesVO.setStateName("");
        }
        //fee_price
        BusinessCommunity businessCommunity = businessCommunityService.selectByCommunityId(feesVO.getCommunityId());
        if (businessCommunity != null) {
            feesVO.setFeePrice(businessCommunity.getFeePrice());
        } else {
            feesVO.setFeePrice("");
        }
        //状态码转换数据据
        //FeeTypeCd
        TDict tDict4 = itDictService.selectByStatus(feesVO.getFeeTypeCd(), "pay_fee_config", "fee_type_cd");
        if (tDict4 != null) {
            feesVO.setFeeTypeCd(tDict4.getName());
        }
        //payerObjType付费对象类型
        TDict tDict5 = itDictService.selectByStatus(feesVO.getPayerObjType(), "pay_fee", "payer_obj_type");
        if (tDict5 != null) {
            feesVO.setPayerObjType(tDict5.getName());
        }
        //paymentCd付费类型
        TDict tDict6 = itDictService.selectByStatus(feesVO.getPaymentCd(), "pay_fee_config", "payment_cd");
        if (tDict6 != null) {
            feesVO.setPaymentCd(tDict6.getName());
        }
        //state状态
        TDict tDict7 = itDictService.selectByStatus(feesVO.getState(), "pay_fee", "state");
        if (tDict7 != null) feesVO.setState(tDict7.getName());

        return feesVO;
    }

    @Override
    public List<String> selectByUserId(List<String> userId) {
        ArrayList<String> list = new ArrayList<>();
        QueryWrapper<Fees> wrapper = new QueryWrapper<>();
        wrapper.in("user_id", userId);
        List<Fees> fees = feeMapper.selectList(wrapper);
        for (Fees fee : fees) {
            list.add(fee.getFeeId());
        }
        return list;
    }

    //通过feed_id来获取user_id,一个fee_id只对应一个user_id
    @Override
    public String selectByFeeId(String fee_id) {
        QueryWrapper<Fees> wrapper = new QueryWrapper<>();
        wrapper.eq("fee_id",fee_id);
        Fees fees = feeMapper.selectOne(wrapper);
        return fees.getUserId();
    }
}
