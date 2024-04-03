package com.zeroone.star.sccommunity.service.meterrecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.meterrecords.QueryShopsHireLogVO;
import com.zeroone.star.sccommunity.entity.meterrecord.QueryShopsHireLog;

public interface IQueryShopsHireLogService extends IService<QueryShopsHireLog> {

    PageVO<QueryShopsHireLogVO> selectByCommunityIdRoomNum(QueryShopsHireLogQuery condition);
}
