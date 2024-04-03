package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.buildingfee.BusinessMeterWater;

public interface IBusinessMeterWaterService extends IService<BusinessMeterWater> {
    BusinessMeterWater selectByFeeId(String feeId);
}
