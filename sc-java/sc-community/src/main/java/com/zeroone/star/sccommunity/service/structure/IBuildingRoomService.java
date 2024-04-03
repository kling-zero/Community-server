package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.sccommunity.entity.structure.BuildingRoom;

import java.util.List;

public interface IBuildingRoomService extends IService<BuildingRoom> {
    BuildingRoom selectById(String userId);

    //通过community_id查询有list的unit_id
    List<String> selectUnitId(String communityId);

    BuildingRoom selectByRoomId(String roomId);

    //通过communityId和RoomNum来查询用户列表，表示这个房间的曾经用户
    //List<String> selectByCommunityIdRoomNum(String communityId,String roomNum);

    //通过communityId和RoomNum获取user_id的list
    List<String> selectByCommunityIdRoomNum(QueryShopsHireLogQuery condition);
}
