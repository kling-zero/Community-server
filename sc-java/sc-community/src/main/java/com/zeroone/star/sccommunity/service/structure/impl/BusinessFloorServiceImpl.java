package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.structure.BusinessFloor;
import com.zeroone.star.sccommunity.mapper.structure.BusinessFloorMapper;
import com.zeroone.star.sccommunity.service.structure.IBusinessFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFloorServiceImpl extends ServiceImpl<BusinessFloorMapper, BusinessFloor> implements IBusinessFloorService {
    @Autowired
    BusinessFloorMapper businessFloorMapper;

    @Override
    public BusinessFloor selectById(String userid) {
        QueryWrapper<BusinessFloor> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userid);
        BusinessFloor businessFloor = businessFloorMapper.selectOne(wrapper);
        return businessFloor;
    }

    @Override
    public BusinessFloor selectByFloorId(String FloorId) {
        QueryWrapper<BusinessFloor> wrapper = new QueryWrapper<>();
        wrapper.eq("floor_id",FloorId);
        BusinessFloor businessFloor = businessFloorMapper.selectOne(wrapper);
        return businessFloor;
    }
}
