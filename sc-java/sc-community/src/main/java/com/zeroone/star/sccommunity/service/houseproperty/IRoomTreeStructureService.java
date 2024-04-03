package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomTreeStructureVO;
import com.zeroone.star.sccommunity.entity.houseproperty.RoomTreeStructure;

public interface IRoomTreeStructureService extends IService<RoomTreeStructure> {
    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<RoomTreeStructureVO> queryAllRoomTreeStructure(RoomStructureQuery query);
}
