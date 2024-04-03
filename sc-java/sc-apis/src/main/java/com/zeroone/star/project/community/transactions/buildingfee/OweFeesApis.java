package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.PayOweFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.owefees.OweFeesQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.owefees.OweFeesVO;

/**
 * 欠费缴费接口
 */
public interface OweFeesApis {
    /**
     * 查询欠费数据
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<OweFeesVO>> queryOweFees(OweFeesQuery condition);

    /**
     * 缴费
     * @param dto
     * @return
     */
    JsonVO<String> payOweFeeJson(PayOweFeeDTO dto);
}
