package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.FeeComboDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboMemberByComboIdQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboMemberVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboVO;

import java.util.List;

/**
 * 费用套餐接口
 */
public interface FeeComboApis {
    /**
     * 选择套餐接口-查询费用套餐
     * @param condition
     * @return
     */
    JsonVO<List<FeeComboVO>> queryFeeComboMember(FeeComboQuery condition);

    /**
     * 选择套餐接口-选择 根据套餐ID查询套餐信息
     * @param condition
     * @return
     */
    JsonVO<List<FeeComboMemberVO>> queryFeeComboMemberByComboId(FeeComboMemberByComboIdQuery condition);

    /**
     * 创建 - 添加费用套餐
     * @param dto
     * @return
     */
    JsonVO<String> addFeeCombo(FeeComboDTO dto);
}
