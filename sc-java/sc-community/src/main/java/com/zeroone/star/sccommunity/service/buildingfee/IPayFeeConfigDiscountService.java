package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFeeConfigDiscount;

public interface IPayFeeConfigDiscountService extends IService<PayFeeConfigDiscount> {
    PayFeeConfigDiscount selectByConfigId(String configId);
}
