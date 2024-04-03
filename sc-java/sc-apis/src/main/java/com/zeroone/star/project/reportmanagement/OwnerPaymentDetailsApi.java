package com.zeroone.star.project.reportmanagement;


import com.zeroone.star.project.dto.reportmanagement.OwnerPaymentDetailsDTO;
import com.zeroone.star.project.query.reportmanagement.OwnerPaymentQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;

import java.util.List;

/**
 * @Author: j4
 * @Date: 2022.10.24
 * @Description: 业主缴费明细Api
 */
public interface OwnerPaymentDetailsApi {

    /**
     * 获取业主缴费明细
     *
     * @return
     * @para
     */
    JsonVO<PageVO<List<OwnerPaymentDetailsDTO>>> getOwnerPaymentDetails(OwnerPaymentQuery condition);


}
