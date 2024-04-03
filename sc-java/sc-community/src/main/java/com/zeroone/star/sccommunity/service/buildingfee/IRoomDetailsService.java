package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.ListRoomQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import com.zeroone.star.sccommunity.entity.buildingfee.RoomDetail;

public interface IRoomDetailsService extends IService<RoomDetail> {

    PageVO<RoomVO> listAll(ListRoomQuery condition);
}
