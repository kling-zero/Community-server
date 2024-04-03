package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.sccommunity.entity.structure.BuildingRoom;
import com.zeroone.star.sccommunity.mapper.structure.BuildingRoomMapper;
import com.zeroone.star.sccommunity.service.structure.IBuildingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据用户id查询房屋编号
 */
@Service
public class BuildingRoomServiceImpl extends ServiceImpl<BuildingRoomMapper, BuildingRoom> implements IBuildingRoomService {
    @Autowired
    BuildingRoomMapper buildingRoomMapper;

    @Override
    public BuildingRoom selectById(String userId) {
        QueryWrapper<BuildingRoom> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        BuildingRoom buildingRoom = buildingRoomMapper.selectOne(wrapper);
        return buildingRoom;
    }

    @Override
    public List<String> selectUnitId(String communityId) {
        ArrayList<String> list = new ArrayList<>();
        QueryWrapper<BuildingRoom> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", communityId);
        List<BuildingRoom> buildingRoomList = buildingRoomMapper.selectList(wrapper);
        for (BuildingRoom buildingRoom : buildingRoomList) {
            list.add(buildingRoom.getUnitId());
        }
        return list;
    }

    @Override
    public BuildingRoom selectByRoomId(String roomId) {
        QueryWrapper<BuildingRoom> wrapper = new QueryWrapper<>();
        wrapper.eq("room_id", roomId);
        BuildingRoom buildingRoom = buildingRoomMapper.selectOne(wrapper);
        return buildingRoom;
    }

    @Override
    public List<String> selectByCommunityIdRoomNum(QueryShopsHireLogQuery condition) {
        ArrayList<String> listId = new ArrayList<>();
        QueryWrapper<BuildingRoom> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",condition.getCommunityId()).eq("room_num",condition.getRoomNum());
        List<BuildingRoom> list = buildingRoomMapper.selectList(wrapper);
        for (BuildingRoom room : list) {
            listId.add(room.getUserId());
        }
        return listId;
    }


}
