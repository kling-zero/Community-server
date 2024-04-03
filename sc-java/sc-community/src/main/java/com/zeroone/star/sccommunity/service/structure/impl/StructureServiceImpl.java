package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.carStructure.CarStructureQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.CarStructureVO;
import com.zeroone.star.sccommunity.entity.structure.*;
import com.zeroone.star.sccommunity.mapper.structure.CarStructureMapper;
import com.zeroone.star.sccommunity.service.structure.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 业峰
 */
@Service
public class StructureServiceImpl extends ServiceImpl<CarStructureMapper, CarStructure> implements StrIStructureService {
    @Autowired
    CarStructureMapper structureMapper;
    @Autowired
    IUnitService unitService;
    @Autowired
    IBuildingOwnerService buildingOwnerService;
    @Autowired
    IBusinessFloorService businessFloorService;
    @Autowired
    IFeeDetailService feeDetailService;
    @Autowired
    IBuildingRoomService buildingRoomService;

    @Override
    public PageVO<CarStructureVO> listAll(CarStructureQuery condition) {
        //1.先查owner_car表查出可用字段
        Page<CarStructure> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<CarStructure> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(condition.getCommunityId()), "community_id", condition.getCommunityId());
        Page<CarStructure> pages = structureMapper.selectPage(page, wrapper);
        //2.对owner_car表中没有的字段进行多表查询
        //2.1转换unit
        Unit unit = unitService.selectById(condition.getUnitId());
        for (CarStructure carStructure : pages.getRecords()) {
            //2.1转换unit
            carStructure.setUnitId(condition.getUnitId());
            if (unit != null) {
                carStructure.setUnitNum(unit.getUnitNum());
            } else {
                carStructure.setUnitNum("");
            }
            //2.2转换业主信息
            BuildingOwner buildingOwner = buildingOwnerService.selectById(carStructure.getOwnerId());
            if (buildingOwner != null) {
                carStructure.setLink(buildingOwner.getLink());
                carStructure.setOwnerName(buildingOwner.getName());
                carStructure.setIdCard(buildingOwner.getIdCard());
            } else {
                carStructure.setLink("");
                carStructure.setOwnerName("");
                carStructure.setIdCard("");
            }
            //2.3楼编号转换
            BusinessFloor businessFloor = businessFloorService.selectById(buildingOwner.getUserId());
            if (businessFloor != null) {
                carStructure.setFloorNum(businessFloor.getFloorNum());
            } else {
                carStructure.setFloorNum("");
            }
            //2.4欠费金额转换
            FeeDetail feeDetail = feeDetailService.selectById(carStructure.getOwnerId());
            if (feeDetail != null) {
                carStructure.setOweAmount(feeDetail.getOweAmount());
            } else {
                //查询不到就设为0.0，因为为double性
                carStructure.setOweAmount(0.0);
            }
            //2.5房屋编号转换
            BuildingRoom buildingRoom = buildingRoomService.selectById(buildingOwner.getUserId());
            if (buildingRoom != null) {
                carStructure.setRoomNum(buildingRoom.getRoomNum());
            } else {
                carStructure.setRoomNum("");
            }
        }
        return PageVO.create(pages, CarStructureVO.class);
    }
}
