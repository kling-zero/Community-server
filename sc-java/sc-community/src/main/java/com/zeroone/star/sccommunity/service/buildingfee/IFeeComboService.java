package com.zeroone.star.sccommunity.service.buildingfee;

import com.zeroone.star.project.dto.community.transactions.buildingfee.FeeComboDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboMemberByComboIdQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboMemberVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboVO;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeCombo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author derrick
 * @since 2022-10-23
 */
public interface IFeeComboService extends IService<FeeCombo> {

    /**
     * 分页查询所有费用套餐记录
     * @param feeComboQuery
     * @return 分页结果
     */
    PageVO<FeeComboVO> listAll(FeeComboQuery feeComboQuery);

    /**
     * 根据ID查询记录
     * @param feeComboMemberByComboIdQuery
     * @return 分页结果
     */
    PageVO<FeeComboMemberVO> getById(FeeComboMemberByComboIdQuery feeComboMemberByComboIdQuery);

    /**
     * 添加记录
     * @param feeComboDTO
     * @return 添加记录结果
     */
    int insert(FeeComboDTO feeComboDTO);

}
