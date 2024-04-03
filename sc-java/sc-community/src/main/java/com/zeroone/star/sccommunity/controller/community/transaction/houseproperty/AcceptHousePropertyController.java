package com.zeroone.star.sccommunity.controller.community.transaction.houseproperty;

import com.zeroone.star.project.community.transactions.acceptHouseProperty.AcceptHousePropertyApis;
import com.zeroone.star.project.dto.community.myCommunity.SavaHandOverDTO;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.AcceptHousePropertyQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.OwnersQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.PayFeeConfigQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.*;
import com.zeroone.star.sccommunity.service.houseproperty.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */

@RestController
@RequestMapping("/acceptHouseProperty")
@Api(tags = "受理房产")
@Validated
public class AcceptHousePropertyController implements AcceptHousePropertyApis {
    @Autowired
    IRoomCreateFeeService iRoomCreateFeeService;
    @Autowired
    IUnitsAndFloorService iUnitsAndFloorService;
    @Autowired
    IMMenuUserService imMenuUserService;
    @Autowired
    IRoomTreeStructureService iRoomTreeStructureService;
    @Autowired
    IOwnersService iOwnersService;
    @Autowired
    IPayFeeConfigService iPayFeeConfigService;
    @Autowired
    IAcceptHousePropertyService iAcceptHousePropertyService;
    @Autowired
    ISaveHandOverService iSaveHandOverService;
    @GetMapping("/listAcceptHouseProperty")
    @ApiOperation("查询受理房产业主信息")
    @Override
    public JsonVO<AcceptHousePropertyVO> queryOne(AcceptHousePropertyQuery condition) {
        return JsonVO.success(iAcceptHousePropertyService.queryOne(condition));
    }

    @GetMapping("/queryAllUnits")
    @ApiOperation("查询受理小区所有单元")
    @Override
    public JsonVO<PageVO<UnitsAndFloorVO>> queryAllUnits(UnitsAndFloorQuery condition) {
        return JsonVO.success(iUnitsAndFloorService.queryAllUnits(condition));
    }
    @GetMapping("/listRoomTreeSturcture")
    @ApiOperation("查询受理小区树状结构图")
    @Override
    public JsonVO<PageVO<RoomTreeStructureVO>> queryAllRoomTreeStructure(RoomStructureQuery condition) {
        return JsonVO.success(iRoomTreeStructureService.queryAllRoomTreeStructure(condition));
    }
    @GetMapping("/queryListMenuUser")
    @ApiOperation("查询用户菜单")
    @Override
    public JsonVO<PageVO<UserMenuVO>> queryListMenuUser(UserMenuQuery condition) {
        return JsonVO.success(imMenuUserService.queryListMenuUser(condition));
    }
    @GetMapping("/listPayFeeConfig")
    @ApiOperation("交房付费查询")
    @Override
    public JsonVO<PayFeeConfigVO> queryPayFeeConfig(PayFeeConfigQuery condition) {
        return JsonVO.success(iPayFeeConfigService.queryPayFeeConfig(condition));
    }

    @GetMapping ("/roomCreateFeeAdd")
    @ApiOperation("查询房屋费用")
    @Override
    public JsonVO<PageVO<RoomCreateFeeAddVO>> addRoomCreateFee(RoomCreateFeeAddQuery condition) {
        return JsonVO.success(iPayFeeConfigService.addRoomCreateFee(condition));
    }

    @PutMapping ("/saveHandOver")
    @ApiOperation("创建费用")
    @Override
    public JsonVO<PageVO> saveHandOver(SavaHandOverDTO data) {
        return JsonVO.success(iSaveHandOverService.saveHandOver(data));
    }

    @GetMapping("/queryAllOwners")
    @ApiOperation("查询房屋拥有者")
    @Override
    public JsonVO<PageVO<OwnersVO>> queryAllOwners(OwnersQuery condition) {
        return JsonVO.success(iOwnersService.queryAllOwners(condition));
    }

    @GetMapping("/queryAllRoomsFee")
    @ApiOperation("查询所有房屋费用")
    @Override
    public JsonVO<PageVO<RoomCreateFeeAddVO>> queryAllRoomsFee(RoomCreateFeeAddQuery condition) {
        return JsonVO.success(iRoomCreateFeeService.queryAllRoomsFee(condition));
    }


}
