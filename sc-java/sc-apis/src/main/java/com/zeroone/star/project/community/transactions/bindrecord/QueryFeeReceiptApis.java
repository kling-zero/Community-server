package com.zeroone.star.project.community.transactions.bindrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.bindrecord.QueryFeeReceiptQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.bindrecord.QueryFeeReceiptVO;

/**
 * 房屋费
 * @author Tomcat
 * @Date 2022/10/16 9:36
 */
public interface QueryFeeReceiptApis {
    /**
     * 分页查询房屋费
     * @param bindRecordQuery 房屋费数据查询对象
     * @return 返回查询结果
     */
    JsonVO<PageVO<QueryFeeReceiptVO>> queryByHouse(QueryFeeReceiptQuery bindRecordQuery);
}
