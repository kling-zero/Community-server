package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.structure.FeeDetail;

public interface IFeeDetailService extends IService<FeeDetail> {
    FeeDetail selectById(String ownerId);
}
