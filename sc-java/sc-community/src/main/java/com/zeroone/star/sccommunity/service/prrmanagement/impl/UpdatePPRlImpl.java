package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.propertyrightregistration.UpdatePPRlDTO;

import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.BuildingRoom;
import com.zeroone.star.sccommunity.entity.prrmanagement.BuildingUnit;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import com.zeroone.star.sccommunity.entity.prrmanagement.UpdatePPRl;
//import com.zeroone.star.sccommunity.mapper.prrmanagement.BuildingRoomMapper;
//import com.zeroone.star.sccommunity.mapper.prrmanagement.BuildingUnitMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRBuildingRoomMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRBuildingUnitMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.UpdatePRRlMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IBuildingRoomService;
import com.zeroone.star.sccommunity.service.prrmanagement.IBuildingUnitService;
import com.zeroone.star.sccommunity.service.prrmanagement.IUpdatePPRlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UpdatePPRlImpl extends ServiceImpl<UpdatePRRlMapper, UpdatePPRl> implements IUpdatePPRlService {

    @Autowired
    UpdatePRRlMapper mapper;

    @Autowired
    PRRBuildingUnitMapper unitMapper;

    @Autowired
    PRRBuildingRoomMapper roomMapper;

    @Autowired
    IUpdatePPRlService service;

    @Autowired
    IBuildingRoomService brservice;

    @Autowired
    IBuildingUnitService buservice;


    @Override
    public void updatePRRl(UpdatePPRlDTO condition) {
        UpdatePPRl updatePPRl = new UpdatePPRl();
        BuildingRoom buildingRoom = new BuildingRoom();
        BuildingUnit buildingUnit = new BuildingUnit();


        UpdateWrapper<UpdatePPRl> wrapper = new UpdateWrapper<>();
        wrapper.eq("prr_id", condition.getPrrId());
        PRRVO prrvo = new PRRVO();

        updatePPRl.setName(condition.getName());
        updatePPRl.setRoomId(condition.getRoomId());
        updatePPRl.setAddress(condition.getAddress());
        updatePPRl.setIdCard(condition.getIdCard());
        updatePPRl.setLink(condition.getLink());
        //进行更新操作，变为未审核，状态为0
        updatePPRl.setState("0");
        updatePPRl.setRemark("");
        prrvo.setState("未审核");


        service.update(updatePPRl,wrapper);

        UpdateWrapper<BuildingRoom> wrapper1 = new UpdateWrapper<>();
        wrapper1.eq("room_id", condition.getRoomId());
        buildingRoom.setRoomId(condition.getRoomId());
        buildingRoom.setUnitId(condition.getUnitId());
        brservice.update(buildingRoom, wrapper1);

        UpdateWrapper<BuildingUnit> wrapper2 = new UpdateWrapper<>();
        wrapper2.eq("unit_id", condition.getUnitId());
        buildingUnit.setUnitId(condition.getUnitId());
        buildingUnit.setFloorId(condition.getFloorId());
        buservice.update(buildingUnit, wrapper2);
    }
}
