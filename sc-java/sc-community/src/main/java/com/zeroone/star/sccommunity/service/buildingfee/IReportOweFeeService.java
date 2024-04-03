package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.buildingfee.ReportOweFee;

public interface IReportOweFeeService extends IService<ReportOweFee> {

    ReportOweFee selectByFeeId(String feeId);
}
