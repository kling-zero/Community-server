package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.prrmanagement.BuildingRoom;
//import com.zeroone.star.sccommunity.mapper.prrmanagement.BuildingRoomMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRBuildingRoomMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IBuildingRoomService;
import org.springframework.stereotype.Service;

@Service
public class BuildingRoomImpl extends ServiceImpl<PRRBuildingRoomMapper, BuildingRoom> implements IBuildingRoomService {
}
