package com.zeroone.star.project.community.transactions.meterrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.meterrecords.QueryShopsHireLogVO;

/**
 * 抄表记录
 * @author Tomcat
 * @Date 2022/10/16 10:14
 */
public interface QueryShopsHireLogApis {
    /**
     * 分页查询抄表记录
     *
     * @param recordsQuery 抄表记录领域模型
     * @return 返回查询结果 json vo
     */
    JsonVO<PageVO<QueryShopsHireLogVO>> queryAll(QueryShopsHireLogQuery recordsQuery);
}
