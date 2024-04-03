package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.buildingfee.FeeConfigsQuery;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFeeConfig;

import java.util.List;

public interface IPayFeeConfigService extends IService<PayFeeConfig> {
    PayFeeConfig selectByConfigId(String configId);
    List<FeeConfigsVO> listFeeConfigs(FeeConfigsQuery condition);
}
