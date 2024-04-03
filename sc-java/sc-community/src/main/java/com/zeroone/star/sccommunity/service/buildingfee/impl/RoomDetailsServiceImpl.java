package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.ListRoomQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import com.zeroone.star.sccommunity.entity.buildingfee.RoomDetail;
import com.zeroone.star.sccommunity.entity.structure.BuildingOwner;
import com.zeroone.star.sccommunity.entity.structure.BusinessFloor;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.entity.structure.UnitsAndFloor;
import com.zeroone.star.sccommunity.mapper.buildingfee.RoomDetailsMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IRoomDetailsService;
import com.zeroone.star.sccommunity.service.structure.IBuildingOwnerService;
import com.zeroone.star.sccommunity.service.structure.IBuildingUnitService;
import com.zeroone.star.sccommunity.service.structure.IBusinessFloorService;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 处理查询房间信息业务
 *
 * @Author：业峰
 */
@Service
public class RoomDetailsServiceImpl extends ServiceImpl<RoomDetailsMapper, RoomDetail> implements IRoomDetailsService {
    @Resource
    RoomDetailsMapper roomDetailsMapper;
    @Resource
    IBuildingOwnerService buildingOwnerService;
    @Resource
    IBuildingUnitService buildingUnitService;
    @Resource
    IBusinessFloorService businessFloorService;
    @Resource
    ITDictService tDictService;

    @Override
    public PageVO<RoomVO> listAll(ListRoomQuery condition) {
        Page<RoomDetail> roomDetailPage = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<RoomDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", condition.getCommunityId())
                .eq("room_id", condition.getRoomId());
        Page<RoomDetail> page = roomDetailsMapper.selectPage(roomDetailPage, wrapper);

        //对查询到的数据进行数据拓展封装
        for (RoomDetail roomDetail : page.getRecords()) {
            //1.封装owner业主数据
            BuildingOwner buildingOwner = buildingOwnerService.selectByUserId(roomDetail.getUserId());
            if (buildingOwner != null) {
                roomDetail.setIdCard(buildingOwner.getIdCard());
                roomDetail.setLink(buildingOwner.getLink());
                roomDetail.setOwnerId(buildingOwner.getOwnerId());
                roomDetail.setOwnerName(buildingOwner.getName());
            } else {
                roomDetail.setIdCard("");
                roomDetail.setLink("");
                roomDetail.setOwnerId("");
                roomDetail.setOwnerName("");
            }
            //2.封装unit单元数据
            UnitsAndFloor unit = buildingUnitService.selectByUnitId(roomDetail.getUnitId());
            if (unit != null) {
                roomDetail.setUnitNum(unit.getUnitNum());
                roomDetail.setFloorId(unit.getFloorId());
            } else {
                roomDetail.setUnitNum("");
                roomDetail.setFloorId("");
            }
            //3.floor楼层数据封装
            BusinessFloor businessFloor = businessFloorService.selectByFloorId(roomDetail.getFloorId());
            if (businessFloor != null) {
                roomDetail.setFloorNum(businessFloor.getFloorNum());
            } else {
                roomDetail.setFloorNum("");
            }
            //4.状态码的对应状态名封装
            //RoomSubTypeName
            TDict tDict = tDictService.selectByStatus(roomDetail.getRoomSubType(), "building_room", "room_sub_type");
            if (tDict != null) {
                roomDetail.setRoomSubTypeName(tDict.getName());
            } else {
                roomDetail.setRoomSubTypeName("");
            }
            //StateName
            TDict tDict1 = tDictService.selectByStatus(roomDetail.getState(), "building_room", "state");
            if (tDict1 != null) {
                roomDetail.setStateName(tDict1.getName());
            } else {
                roomDetail.setStateName("");
            }
            //roomType
            TDict tDict2 = tDictService.selectByStatus(roomDetail.getRoomType(), "building_room", "room_type");
            if (tDict2 != null) roomDetail.setRoomType(tDict2.getName());
        }
        return PageVO.create(page, RoomVO.class);
    }
}
