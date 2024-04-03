package com.zeroone.star.sccommunity.controller;

import com.zeroone.star.project.community.structure.carStructure.CarStructureApis;
import com.zeroone.star.project.query.community.structure.carStructure.CarStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.community.structure.carStructure.CarStructureVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.project.vo.community.structure.roomStructure.RoomStructureVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.sccommunity.service.structure.IBuildingUnitService;
import com.zeroone.star.sccommunity.service.structure.IRoomStructureService;
import com.zeroone.star.sccommunity.service.structure.StrIStructureService;
import com.zeroone.star.sccommunity.service.structure.IUserMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */
@RestController
@RequestMapping("/carStructure")
@Api(tags = "结构图查询")
@Validated
public class CarStructureController implements CarStructureApis {

    @Autowired
    StrIStructureService structureService;
    @Autowired
    IBuildingUnitService buildingUnitService;
    @Autowired
    IUserMenuService userMenuService;
    @Autowired
    IRoomStructureService roomStructureService;

    @GetMapping("/listCarStructure")
    @ApiOperation("查询所有车位结构图")
    @Override
    public JsonVO<PageVO<CarStructureVO>> queryAll(CarStructureQuery condition) {
        PageVO<CarStructureVO> pageVO = structureService.listAll(condition);
        return JsonVO.create(pageVO, ResultStatus.SUCCESS);
    }

    /**
     * 通过小区id查询所有属于改小区的单元楼层结构数据
     *
     * @param condition
     * @return
     */
    @GetMapping("/listUnitsAndFloor")
    @ApiOperation("查询所有单元楼层结构图")
    @Override
//    public JsonVO<UnitsAndFloorVO>这里面有page信息应该返回的是pageVO
    public JsonVO<PageVO<UnitsAndFloorVO>> queryAllUnit(UnitsAndFloorQuery condition) {
        PageVO<UnitsAndFloorVO> pageVO = buildingUnitService.listAll(condition);
        if (pageVO == null) {
            return JsonVO.create(null, ResultStatus.PARAMS_INVALID);
        }
        return JsonVO.create(pageVO, ResultStatus.SUCCESS);
    }

    @GetMapping("/listRoomStructure")
    @ApiOperation("查询所有房屋结构图")
    @Override
    public JsonVO<PageVO<RoomStructureVO>> queryAll(RoomStructureQuery condition) {
        PageVO<RoomStructureVO> roomStructureVOPageVO = roomStructureService.listByCondition(condition);
        return JsonVO.create(roomStructureVOPageVO,ResultStatus.SUCCESS);
    }

    @GetMapping("/listUserMenu")
    @ApiOperation(value = "查询用户菜单")
    @Override
    public JsonVO<PageVO<UserMenuVO>> queryAllUserMenu(UserMenuQuery condition) {
        PageVO<UserMenuVO> userMenuVOPageVO = userMenuService.listAllUserMenu(condition);
        return JsonVO.create(userMenuVOPageVO,ResultStatus.SUCCESS);
    }
}
