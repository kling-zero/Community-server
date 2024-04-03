package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.prrmanagement.BuildingUnit;
//import com.zeroone.star.sccommunity.mapper.prrmanagement.BuildingUnitMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRBuildingUnitMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IBuildingUnitService;
import org.springframework.stereotype.Service;

@Service
public class BuildingUnitImpl extends ServiceImpl<PRRBuildingUnitMapper, BuildingUnit> implements IBuildingUnitService {
}
