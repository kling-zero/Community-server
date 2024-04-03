package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.FeeDetailsQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.FeeDetailsVO;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeHistory;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.mapper.buildingfee.FeeHistoryMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeHistoryService;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询缴费历史业务
 *
 * @业峰
 */
@Service
public class FeeHistoryServiceImpl extends ServiceImpl<FeeHistoryMapper, FeeHistory> implements IFeeHistoryService {
    @Autowired
    FeeHistoryMapper feeHistoryMapper;
    @Autowired
    ITDictService itDictService;

    @Override
    public PageVO<FeeDetailsVO> listFeeDetailHistory(FeeDetailsQuery condition) {
        Page<FeeHistory> feeDetailsPage = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<FeeHistory> wrapper = new QueryWrapper<>();
        //查询所有在相同小区id与费用id下的数据
        wrapper.eq("community_id", condition.getCommunityId())
                .eq("fee_id", condition.getFeeId());
        //查询时间段的数据
        if (condition.getStartTime() != null && condition.getEndTime() != null) {
            //一下方式判断输入时间是否为空会报错
//            wrapper.ge(StringUtils.isNotBlank(condition.getStartTime().toString()),"start_time",condition.getStartTime())
//                    .le(StringUtils.isNotBlank(condition.getEndTime().toString()),"end_time",condition.getEndTime());
            wrapper.ge("start_time", condition.getStartTime())
                    .le("end_time", condition.getEndTime());
        }
        Page<FeeHistory> pages = feeHistoryMapper.selectPage(feeDetailsPage, wrapper);
        //对状态码封装
        for (FeeHistory feeHistory : pages.getRecords()) {
            TDict tDict = itDictService.selectByStatus(feeHistory.getState(), "pay_fee_detail", "state");
            if (tDict != null) feeHistory.setState(tDict.getName());
        }
        return PageVO.create(pages, FeeDetailsVO.class);
    }
}
