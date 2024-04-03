package com.zeroone.star.project.community.transactions.bindrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.bindrecord.QueryContractQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.bindrecord.QueryContractVO;

/**
 * @author Tomcat
 * @Date 2022/10/16 16:29
 */
public interface QueryContractApis {
    /**
     * 合同费
     * @param contractQuery 合同费数据查询对象
     * @return 返回查询结果
     */
    JsonVO<PageVO<QueryContractVO>> queryByContract(QueryContractQuery contractQuery);
}
