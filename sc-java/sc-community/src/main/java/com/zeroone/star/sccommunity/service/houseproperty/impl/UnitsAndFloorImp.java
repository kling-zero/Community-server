package com.zeroone.star.sccommunity.service.houseproperty.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.sccommunity.entity.houseproperty.BusinessFloor;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingUnit;
import com.zeroone.star.sccommunity.entity.houseproperty.UnitsAndFloor;
import com.zeroone.star.sccommunity.mapper.houseproperty.BuildingUnitMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBusinessFloorMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.UnitsAndFloorMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IUnitsAndFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/22
 */
@Service
public class UnitsAndFloorImp extends ServiceImpl<UnitsAndFloorMapper, UnitsAndFloor> implements IUnitsAndFloorService {
    @Autowired
    BuildingUnitMapper buildingUnitMapper;
    @Autowired
    UnitsAndFloorMapper unitsAndFloorMapper;
    @Autowired
    HouseBusinessFloorMapper businessFloorMapper;

    @Override
    public PageVO<UnitsAndFloorVO> queryAllUnits(UnitsAndFloorQuery query) {
        String communityId = query.getCommunityId();
        Page<BuildingUnit> page = new Page<>(query.getPageIndex(),query.getPageSize());
        QueryWrapper<BuildingUnit> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",communityId);
        Page<BuildingUnit> pages = buildingUnitMapper.selectPage(page,wrapper);
        for (BuildingUnit buildingUnit: pages.getRecords()) {
            QueryWrapper<BusinessFloor> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("floor_id",buildingUnit.getFloorId());
            BusinessFloor businessFloor = businessFloorMapper.selectOne(queryWrapper);
            buildingUnit.setFloorNum(businessFloor.getFloorNum());
            buildingUnit.setSeq(businessFloor.getSeq());
        }
        return PageVO.create(pages,UnitsAndFloorVO.class);
    }
}
