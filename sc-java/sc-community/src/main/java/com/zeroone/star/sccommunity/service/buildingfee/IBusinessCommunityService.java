package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.buildingfee.BusinessCommunity;

public interface IBusinessCommunityService extends IService<BusinessCommunity> {
    BusinessCommunity selectByCommunityId(String communityId);
}
