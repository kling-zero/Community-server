package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.sccommunity.entity.houseproperty.UnitsAndFloor;
import org.springframework.stereotype.Service;


public interface IUnitsAndFloorService extends IService<UnitsAndFloor> {
    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<UnitsAndFloorVO> queryAllUnits(UnitsAndFloorQuery query);
}
