package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFeeConfigDiscount;
import com.zeroone.star.sccommunity.mapper.buildingfee.PayFeeConfigDiscountMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IPayFeeConfigDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayFeeConfigDiscountServiceImpl extends ServiceImpl<PayFeeConfigDiscountMapper, PayFeeConfigDiscount> implements IPayFeeConfigDiscountService {
   @Autowired
    PayFeeConfigDiscountMapper payFeeConfigDiscountMapper;

    @Override
    public PayFeeConfigDiscount selectByConfigId(String configId) {
        QueryWrapper<PayFeeConfigDiscount> wrapper = new QueryWrapper<>();
        wrapper.eq("config_id",configId);
        PayFeeConfigDiscount payFeeConfigDiscount = payFeeConfigDiscountMapper.selectOne(wrapper);
        return payFeeConfigDiscount;
    }
}
