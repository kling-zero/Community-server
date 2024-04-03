package com.zeroone.star.project.community.transactions.buildingfee;

import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.ListRoomQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.FeeDetailsQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.FeeDetailsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;

import java.util.List;

/**
 * 缴费历史接口
 */
public interface FeeDetailsApis {

    /**
     * 查询费用信息
     * @param condition
     * @return
     */
    JsonVO<FeesVO> getFee(OwnerAccountQuery condition);

    /**
     * 查询房间信息
     * @param condition
     * @return
     */
    JsonVO<List<RoomVO>> queryRoomByRoomId(ListRoomQuery condition);


    /**
     * 查询缴费历史
     * @param condition
     * @return
     */
    JsonVO<List<FeeDetailsVO>> queryFeeDetails(FeeDetailsQuery condition);
}
