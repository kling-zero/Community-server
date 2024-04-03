package com.zeroone.star.sccommunity.service.structure.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.sccommunity.entity.structure.BusinessFloor;
import com.zeroone.star.sccommunity.entity.structure.UnitsAndFloor;
import com.zeroone.star.sccommunity.mapper.structure.BuildingUnitsMapper;
import com.zeroone.star.sccommunity.service.structure.IBuildingRoomService;
import com.zeroone.star.sccommunity.service.structure.IBuildingUnitService;
import com.zeroone.star.sccommunity.service.structure.IBusinessFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingUnitServiceImpl extends ServiceImpl<BuildingUnitsMapper, UnitsAndFloor> implements IBuildingUnitService {
    @Autowired
    IBuildingRoomService buildingRoomService;
    @Autowired
    BuildingUnitsMapper buildingUnitsMapper;
    @Autowired
    IBusinessFloorService businessFloorService;

    @Override
    public PageVO<UnitsAndFloorVO> listAll(UnitsAndFloorQuery condition) {
        Page<UnitsAndFloor> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<UnitsAndFloor> wrapper = new QueryWrapper<>();
        //通过小区id查出单元id的list，表building_room
        List<String> list = buildingRoomService.selectUnitId(condition.getCommunityId());
        //查询条件是单元id在list中
        try {
            wrapper.in("unit_id", list);
            Page<UnitsAndFloor> unitsAndFloorPage = buildingUnitsMapper.selectPage(page, wrapper);
            //对剩余字段进行转换floorNum,seq
            for (UnitsAndFloor unitsAndFloor : unitsAndFloorPage.getRecords()) {
                BusinessFloor businessFloor = businessFloorService.selectByFloorId(unitsAndFloor.getFloorId());
                if (businessFloor != null) {
                    unitsAndFloor.setFloorNum(businessFloor.getFloorNum());
                    unitsAndFloor.setSeq(businessFloor.getSeq());
                } else {
                    unitsAndFloor.setFloorNum("");
                    unitsAndFloor.setSeq(0);
                }
            }
            return PageVO.create(unitsAndFloorPage, UnitsAndFloorVO.class);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("CommunityId数据库没有数据");
            return PageVO.create(null);
        }
    }

    @Override
    public UnitsAndFloor selectByUnitId(String unitId) {
        QueryWrapper<UnitsAndFloor> wrapper = new QueryWrapper<>();
        wrapper.eq("unit_id",unitId);
        UnitsAndFloor unitsAndFloor = buildingUnitsMapper.selectOne(wrapper);
        return unitsAndFloor;
    }
}
