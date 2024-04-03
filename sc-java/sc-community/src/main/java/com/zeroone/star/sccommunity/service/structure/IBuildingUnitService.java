package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.sccommunity.entity.structure.UnitsAndFloor;

public interface IBuildingUnitService extends IService<UnitsAndFloor> {

    PageVO<UnitsAndFloorVO> listAll(UnitsAndFloorQuery condition);

    //根据unitId查询
    UnitsAndFloor selectByUnitId(String unitId);
}
