package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.FeeDetailsQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.FeeDetailsVO;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeHistory;

public interface IFeeHistoryService extends IService<FeeHistory> {
    PageVO<FeeDetailsVO> listFeeDetailHistory(FeeDetailsQuery condition);
}
