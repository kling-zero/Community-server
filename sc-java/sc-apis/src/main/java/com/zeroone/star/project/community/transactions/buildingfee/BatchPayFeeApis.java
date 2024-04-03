package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.BatchPayFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.batchpayfee.BatchPayFeeQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.PayFeeDetailQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.batchpayfee.BatchPayFeeVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;

import java.util.List;

/**
 * 批量缴费接口
 */
public interface BatchPayFeeApis {
    /**
     * 分页查询批量缴费信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<BatchPayFeeVO>> queryBatchPayFee(BatchPayFeeQuery condition);

    /**
     * 列表查询展示支付服务
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<FeeTypeCdsVO>> queryPayFeeDetail(PayFeeDetailQuery condition);

    /**
     * 提交缴费json数据
     * @param dto 提交数据
     * @return 提交数据结果
     */
    JsonVO<String> payBatchFeeJson(BatchPayFeeDTO dto);
}
