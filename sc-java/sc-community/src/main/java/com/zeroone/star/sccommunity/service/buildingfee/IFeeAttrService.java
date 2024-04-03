package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeAttr;

import java.util.List;

public interface IFeeAttrService extends IService<FeeAttr> {
    List<FeeAttr> selectByFeeId(String feeId);
}
