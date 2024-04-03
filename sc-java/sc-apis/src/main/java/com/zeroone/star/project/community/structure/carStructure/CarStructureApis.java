package com.zeroone.star.project.community.structure.carStructure;

import com.zeroone.star.project.query.community.structure.carStructure.CarStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.CarStructureVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.project.vo.community.structure.roomStructure.RoomStructureVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 车位结构查询api
 * @Author 苏乞儿
 * @Date 2022/10/14
 */


public interface CarStructureApis {

    /**
     * 车位结构图查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<CarStructureVO>> queryAll(CarStructureQuery condition);



    JsonVO<PageVO<UnitsAndFloorVO>> queryAllUnit(UnitsAndFloorQuery condition);


    JsonVO<PageVO<RoomStructureVO>> queryAll(RoomStructureQuery condition);


    JsonVO<PageVO<UserMenuVO>> queryAllUserMenu(UserMenuQuery condition);
}
