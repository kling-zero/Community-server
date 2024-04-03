package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.buildingfee.ReportOweFee;
import com.zeroone.star.sccommunity.mapper.buildingfee.ReportOweFeeMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IReportOweFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportOweFeeServiceImpl extends ServiceImpl<ReportOweFeeMapper, ReportOweFee> implements IReportOweFeeService {
    @Autowired
    ReportOweFeeMapper reportOweFeeMapper;

    @Override
    public ReportOweFee selectByFeeId(String feeId) {
        QueryWrapper<ReportOweFee> wrapper = new QueryWrapper<>();
        wrapper.eq("fee_id",feeId);
        ReportOweFee reportOweFee = reportOweFeeMapper.selectOne(wrapper);
        return reportOweFee;
    }
}
