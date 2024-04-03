package com.zeroone.star.project.community.transactions.bindrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.bindrecord.ListFeePrintPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.bindrecord.ListFeePrintPageVO;

/**
 * @author Tomcat
 * @Date 2022/10/16 15:38
 */
public interface ListFeePrintPageApis {
    /**
     * 查询打印
     * @param printPageQuery 打印数据查询对象
     * @return 返回查询对象
     */
    JsonVO<PageVO<ListFeePrintPageVO>> print(ListFeePrintPageQuery printPageQuery);
}
