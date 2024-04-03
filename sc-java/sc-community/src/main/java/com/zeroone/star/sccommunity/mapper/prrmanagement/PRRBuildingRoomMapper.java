package com.zeroone.star.sccommunity.mapper.prrmanagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommunity.entity.prrmanagement.BuildingRoom;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PRRBuildingRoomMapper extends BaseMapper<BuildingRoom> {
}
