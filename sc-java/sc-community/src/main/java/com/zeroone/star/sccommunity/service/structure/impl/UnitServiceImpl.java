package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.structure.Unit;
import com.zeroone.star.sccommunity.mapper.structure.UnitMapper;
import com.zeroone.star.sccommunity.service.structure.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements IUnitService {
    @Autowired
    UnitMapper unitMapper;
    @Override
    public Unit selectById(String unitId) {
        QueryWrapper<Unit> wrapper = new QueryWrapper<>();
        wrapper.eq("unit_id",unitId);
        Unit unit = unitMapper.selectOne(wrapper);
        return unit;
    }

    @Override
    public Unit selectFloorIdByUnitId(String unitId) {

        return null;
    }
}
