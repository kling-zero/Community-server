package com.zeroone.star.sccommunity.service.houseproperty.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomTreeStructureVO;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingOwner;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingRoom;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingUnit;
import com.zeroone.star.sccommunity.entity.houseproperty.RoomTreeStructure;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBuildingOwnerMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBuildingRoomMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.BuildingUnitMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.RoomTreeStructureMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IRoomTreeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/22
 */
@Service
public class RoomTreeStructureImp extends ServiceImpl<RoomTreeStructureMapper, RoomTreeStructure> implements IRoomTreeStructureService {
    @Autowired
    BuildingUnitMapper unitMapper;
    @Autowired
    HouseBuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    HouseBuildingRoomMapper buildingRoomMapper;
    @Autowired
    BuildingUnitMapper buildingUnitMapper;
    @Autowired
   RoomTreeStructureMapper roomTreeStructureMapper;
    @Override
    public PageVO<RoomTreeStructureVO> queryAllRoomTreeStructure(RoomStructureQuery query) {
        Page<RoomTreeStructure> page = new Page<>(query.getPageIndex(),query.getPageSize());
        QueryWrapper<RoomTreeStructure> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",query.getCommunityId()).eq("unit_id",query.getUnitId());
        Page<RoomTreeStructure> pages = roomTreeStructureMapper.selectPage(page,wrapper);
        for (RoomTreeStructure roomTreeStructure : pages.getRecords()) {
                QueryWrapper<BuildingUnit> unitQueryWrapper = new QueryWrapper<>();
                unitQueryWrapper.eq("community_id",query.getCommunityId()).eq("unit_id",query.getUnitId());
                BuildingUnit buildingUnit = buildingUnitMapper.selectOne(unitQueryWrapper);
                QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_id",buildingUnit.getUserId());
                BuildingOwner buildingOwner = buildingOwnerMapper.selectOne(queryWrapper);
                roomTreeStructure.setOwnerId(buildingOwner.getOwnerId());
                roomTreeStructure.setOwnerName(buildingOwner.getName());
                roomTreeStructure.setLink(buildingOwner.getLink());
                QueryWrapper<BuildingRoom> roomQueryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_id",buildingUnit.getUserId());
                BuildingRoom buildingRoom = buildingRoomMapper.selectOne(roomQueryWrapper);
                roomTreeStructure.setUnitId(buildingRoom.getUnitId());
                roomTreeStructure.setRoomNum(buildingRoom.getRoomNum());
                roomTreeStructure.setRoomId(buildingRoom.getRoomId());
                roomTreeStructure.setFloorId(buildingUnit.getFloorId());
                roomTreeStructure.setFloorNum(buildingUnit.getFloorNum());
                roomTreeStructure.setLayer(buildingUnit.getLayerCount());
            }
        return PageVO.create(pages,RoomTreeStructureVO.class);
        }
}
