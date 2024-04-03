package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.roomStructure.RoomStructureVO;
import com.zeroone.star.sccommunity.entity.structure.*;
import com.zeroone.star.sccommunity.mapper.structure.RoomStructureMapper;
import com.zeroone.star.sccommunity.service.structure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:业峰 10-21
 * 操作Building——room房屋结构
 */
@Service
public class RoomStructureServiceImpl extends ServiceImpl<RoomStructureMapper, RoomStructure> implements IRoomStructureService {
    @Autowired
    RoomStructureMapper roomStructureMapper;
    @Autowired
    IUnitService unitService;
    @Autowired
    IBusinessFloorService businessFloorService;
    @Autowired
    IBuildingUnitService buildingUnitService;
    @Autowired
    IBuildingOwnerService buildingOwnerService;
    @Autowired
    IFeeDetailService feeDetailService;
    @Autowired
    IBuildingRoomService buildingRoomService;
    @Autowired
    ITDictService itDictService;

    @Override
    public PageVO<RoomStructureVO> listByCondition(RoomStructureQuery query) {
        Page<RoomStructure> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<RoomStructure> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", query.getCommunityId()).eq("unit_id", query.getUnitId());
        Page<RoomStructure> pages = roomStructureMapper.selectPage(page, wrapper);

        //查询其他数据进行封装
        for (RoomStructure roomStructure : pages.getRecords()) {
            //1.楼ID-floorId
            Unit unit = unitService.selectById(roomStructure.getUnitId());
            if (unit != null) {
                roomStructure.setFloorId(unit.getFloorId());
                //2.楼编号floorNum
                BusinessFloor businessFloor = businessFloorService.selectByFloorId(unit.getFloorId());
                if (businessFloor != null) {
                    roomStructure.setFloorNum(businessFloor.getFloorNum());
                } else {
                    roomStructure.setFloorNum("");
                }
            } else {
                roomStructure.setFloorId("");
                roomStructure.setFloorNum("");
            }
            //3.单元编号unitNum
            UnitsAndFloor unitsAndFloor = buildingUnitService.selectByUnitId(roomStructure.getUnitId());
            if (unitsAndFloor != null) {
                roomStructure.setUnitNum(unitsAndFloor.getUnitNum());
            } else {
                roomStructure.setUnitNum("");
            }
            //4.身份证号码idCard、联系人手机号link、业主IDownerId、业主姓名ownerName
            BuildingOwner buildingOwner = buildingOwnerService.selectByUserId(roomStructure.getUserId());
            if (buildingOwner != null) {
                roomStructure.setIdCard(buildingOwner.getIdCard());
                roomStructure.setLink(buildingOwner.getLink());
                roomStructure.setOwnerId(buildingOwner.getOwnerId());
                roomStructure.setOwnerName(buildingOwner.getName());
            } else {
                roomStructure.setIdCard("");
                roomStructure.setLink("");
                roomStructure.setOwnerId("");
                roomStructure.setOwnerName("");
            }
            //5.欠费金额oweAmount
            FeeDetail feeDetail = feeDetailService.selectById(buildingOwner.getOwnerId());
            if (feeDetail != null) {
                roomStructure.setOweAmount(feeDetail.getOweAmount());
            } else {
                roomStructure.setOweAmount(0.0);
            }
            //6.租金roomRent
            BuildingRoom buildingRoom = buildingRoomService.selectByRoomId(roomStructure.getRoomId());
            if (buildingRoom != null) {
                roomStructure.setRoomRent(buildingRoom.getRoomRent());
            } else {
                roomStructure.setRoomRent(0.0);
            }
            //7.转换状态码数据
            //RoomSubType:110 住宅房屋，119 办公室 120 宿舍
            String roomSubType = roomStructure.getRoomSubType();
            if ("110".equals(roomSubType)) roomStructure.setRoomSubType("住宅房屋");
            if ("119".equals(roomSubType)) roomStructure.setRoomSubType("办公室");
            if ("120".equals(roomSubType)) roomStructure.setRoomSubType("宿舍");
            //state房屋状态
            TDict tDict1 = itDictService.selectByStatus(roomStructure.getState(), "building_room", "state");
            if (tDict1 != null) {
                roomStructure.setState(tDict1.getName());
            }
            //statusCd数据状态
            TDict tDict2 = itDictService.selectByStatus(roomStructure.getStatusCd(), "all", "status_cd");
            if (tDict2 != null) {
                roomStructure.setStatusCd(tDict2.getName());
            }
            //room_type
            TDict tDict3 = itDictService.selectByStatus(roomStructure.getRoomType(), "building_room", "room_type");
            if (tDict3 != null) {
                roomStructure.setRoomType(tDict3.getName());
            }
            //apartment户型、section室找不到状态码对应数据
        }
        return PageVO.create(pages, RoomStructureVO.class);
    }
}
