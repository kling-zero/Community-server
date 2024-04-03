package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.structure.BuildingOwner;
import com.zeroone.star.sccommunity.mapper.structure.StructureBuildingOwnerMapper;
import com.zeroone.star.sccommunity.service.structure.IBuildingOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 根据业主id查询业主其他信息
 */
@Service
public class StructureBuildingOwnerServiceImpl extends ServiceImpl<StructureBuildingOwnerMapper, BuildingOwner> implements IBuildingOwnerService {
    @Autowired
    StructureBuildingOwnerMapper buildingOwnerMapper;

    //根据ownerId查询数据
    @Override
    public BuildingOwner selectById(String ownerId) {
        QueryWrapper<BuildingOwner> wrapper = new QueryWrapper<>();
        wrapper.eq("owner_id",ownerId);
        BuildingOwner buildingOwner = buildingOwnerMapper.selectOne(wrapper);
        return buildingOwner;
    }

    //根据userId查询数据
    @Override
    public BuildingOwner selectByUserId(String userId) {
        QueryWrapper<BuildingOwner> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        BuildingOwner buildingOwner = buildingOwnerMapper.selectOne(wrapper);
        return buildingOwner;
    }
}
