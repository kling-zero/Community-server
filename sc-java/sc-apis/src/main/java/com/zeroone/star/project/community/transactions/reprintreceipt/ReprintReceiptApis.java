package com.zeroone.star.project.community.transactions.reprintreceipt;

import com.zeroone.star.project.query.community.transactions.reprintreceipt.ReceiptQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.CarVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ContractVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.FeeTypeVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ReprintReceiptVO;

import java.util.List;

/**
 * 补打收据
 * @author Tomcat
 * @Date 2022/10/15 21:46
 */
public interface ReprintReceiptApis {
    /**
     * 分页查询补打收据
     * @param receiptQuery 补打收据查询条件领域模型
     * @return 收据列表
     */
    JsonVO<PageVO<ReprintReceiptVO>> queryAll(ReceiptQuery receiptQuery);

    /**
     * 查询费用类型
     * @return 费用类型列表
     */
    JsonVO<List<FeeTypeVO>> queryFeeType();

    /**
     * 获取所有车辆信息
     * @param memberId 成员ID
     * @return 车辆信息列表
     */
    JsonVO<List<CarVO>> queryAllCar(String memberId);

    /**
     * 查询所有合同
     * @param memberId 成员ID
     * @return 合同集合
     */
    JsonVO<List<ContractVO>> queryAllContract(String memberId);
}
