package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.sccommunity.entity.houseproperty.RoomCreateFeeAdd;


public interface IRoomCreateFeeService extends IService<RoomCreateFeeAdd> {

    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<RoomCreateFeeAddVO> queryAllRoomsFee(RoomCreateFeeAddQuery query);
}
