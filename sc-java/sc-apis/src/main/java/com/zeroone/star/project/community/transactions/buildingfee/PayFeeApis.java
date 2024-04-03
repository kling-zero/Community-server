package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.OwnerPrestoreAccountDTO;
import com.zeroone.star.project.dto.community.transactions.buildingfee.PayFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.FeePrintQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.FeeReceiptQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountCycleQuery;
import com.zeroone.star.project.vo.community.transactions.buildfee.payfee.*;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;

import java.util.List;

/**
 * 缴费接口
 */
public interface PayFeeApis {

    /**
     * 分页查询账户信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<OwnerAccountVO>> queryOwnerAccount(OwnerAccountQuery condition);

    /**
     * 查询订单收费的对象的信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<FeeObjVO>> listFeeObj(OwnerAccountQuery condition);

    /**
     * 费用打印展示信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<FeePrintVO>> listFeePrint(FeePrintQuery condition);

    /**
     * 根据周期查询订单收费对象的信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<List<FeeObjCycleVO>> listFeeObjByCycle(OwnerAccountCycleQuery condition);

    /**
     * 缴费-付钱
     * @param dto 提交数据
     * @return 提交数据结果
     */
    JsonVO<PayFeeVO> payFeeJson(PayFeeDTO dto);

    /**
     * 查询费用收据
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<FeeReceiptVO> queryFeeReceipt(FeeReceiptQuery condition);

    /**
     * 预存账户金额
     * @param dto 提交数据
     * @return 提交数据结果
     */
    JsonVO<String> modifyOwnerPretoreAccount(OwnerPrestoreAccountDTO dto);
}
