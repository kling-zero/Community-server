package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.buildingfee.BusinessCommunity;
import com.zeroone.star.sccommunity.mapper.buildingfee.BusinessCommunityMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IBusinessCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCommunityServiceImpl extends ServiceImpl<BusinessCommunityMapper, BusinessCommunity> implements IBusinessCommunityService {
    @Autowired
    BusinessCommunityMapper businessCommunityMapper;
    @Override
    public BusinessCommunity selectByCommunityId(String communityId) {
        QueryWrapper<BusinessCommunity> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",communityId);
        BusinessCommunity businessCommunity = businessCommunityMapper.selectOne(wrapper);
        return businessCommunity;
    }
}
