package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.buildingfee.BusinessMeterWater;
import com.zeroone.star.sccommunity.mapper.buildingfee.BusinessMeterWaterMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IBusinessMeterWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessMeterWaterServiceImpl extends ServiceImpl<BusinessMeterWaterMapper, BusinessMeterWater> implements IBusinessMeterWaterService {
    @Autowired
    BusinessMeterWaterMapper businessMeterWaterMapper;
    @Override
    public BusinessMeterWater selectByFeeId(String feeId) {
        QueryWrapper<BusinessMeterWater> wrapper = new QueryWrapper<>();
        wrapper.eq("fee_id",feeId);
        BusinessMeterWater businessMeterWater = businessMeterWaterMapper.selectOne(wrapper);
        return businessMeterWater;
    }
}
