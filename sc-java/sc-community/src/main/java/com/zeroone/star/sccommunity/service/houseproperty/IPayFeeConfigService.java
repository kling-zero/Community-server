package com.zeroone.star.sccommunity.service.houseproperty;

import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.PayFeeConfigQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.PayFeeConfigVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.sccommunity.entity.houseproperty.PayFeeConfig;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suqier
 * @since 2022-10-21
 */
public interface IPayFeeConfigService extends IService<PayFeeConfig> {
    /**
     * 条件查询账单
     * @param query 查询条件
     * @return 查询结果
     */
    PayFeeConfigVO queryPayFeeConfig(PayFeeConfigQuery query);

    /**
     * 分页条件查询房屋费用
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<RoomCreateFeeAddVO> addRoomCreateFee(RoomCreateFeeAddQuery query);

}
