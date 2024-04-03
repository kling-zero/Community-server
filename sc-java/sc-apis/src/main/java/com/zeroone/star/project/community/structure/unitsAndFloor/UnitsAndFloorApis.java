package com.zeroone.star.project.community.structure.unitsAndFloor;

import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;

/**
 * @Description 单元楼层结构查询api
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

public interface UnitsAndFloorApis {

    /**
     * 查询单元楼层结构
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<UnitsAndFloorVO> queryAll(UnitsAndFloorQuery condition);

}
