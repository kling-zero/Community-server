package com.zeroone.star.sccommunity.service.reprintreceipt;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.reprintreceipt.ReceiptQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.FeeTypeVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ReprintReceiptVO;
import com.zeroone.star.sccommunity.entity.reprintreceipt.PayFee;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author night
 * @since 2022-10-24
 */
public interface IPayFeeService extends IService<PayFee> {

    /**
     * 查询收据列表
     * @param receiptQuery 查询条件
     * @return 收据列表分页对象
     */
    PageVO<ReprintReceiptVO> getAll(ReceiptQuery receiptQuery);

    /**
     * 获取所有费用类型
     * @return 费用类型集合
     */
    List<FeeTypeVO> getTypes();
}
