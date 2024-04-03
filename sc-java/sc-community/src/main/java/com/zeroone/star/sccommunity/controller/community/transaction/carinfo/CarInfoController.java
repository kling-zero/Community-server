package com.zeroone.star.sccommunity.controller.community.transaction.carinfo;

import com.zeroone.star.project.community.transactions.carinfo.CarInfoApis;
import com.zeroone.star.project.dto.community.transactions.carinfo.CarInfoDTO;
import com.zeroone.star.project.query.community.transactions.carinfo.CarInfoQuery;
import com.zeroone.star.project.query.community.transactions.carinfo.ParkingSpaceQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.CarInfoVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.ParkingSpaceVO;
import com.zeroone.star.sccommunity.service.carinfo.IOwnerCarService;
import com.zeroone.star.sccommunity.service.carinfo.IParkingSpaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 车辆信息-控制层
 */
@RestController
@RequestMapping("/carInfo")
@Api(tags = "车辆信息")
@Validated
public class CarInfoController implements CarInfoApis {

    @Autowired
    private IOwnerCarService ownerCarService;
    @Autowired
    private IParkingSpaceService parkingSpaceService;

    @GetMapping("/carInfos")
    @ApiOperation("获取车辆信息列表")
    @Override
    public JsonVO<PageVO<CarInfoVO>> queryCarinfos(CarInfoQuery carInfoQuery) {
        PageVO<CarInfoVO> carInfos = ownerCarService.getCarInfos(carInfoQuery);
        return JsonVO.success(carInfos);
    }

    @PostMapping("/modifyState")
    @ApiOperation("释放车位")
    @Override
    public JsonVO<String> modifyState(String carId) {
        ownerCarService.modifyState(carId);
        return JsonVO.success("修改成功");
    }

    @PostMapping("/modifyInfo")
    @ApiOperation("修改车辆信息")
    @Override
    public JsonVO<String> modifyInfo(CarInfoDTO carInfoDTO) {
        ownerCarService.modifyCarInfo(carInfoDTO);
        return JsonVO.success("修改成功");
    }

    @DeleteMapping("/deleteInfo")
    @ApiOperation("删除车辆信息")
    @Override
    public JsonVO<String> deleteInfo(String carId) {
        ownerCarService.deleteCarInfo(carId);
        return JsonVO.success("删除成功");
    }

    @PutMapping("/addInfo")
    @ApiOperation("新增车辆信息")
    @Override
    public JsonVO<String> addInfo(CarInfoDTO carInfoDTO) {
        ownerCarService.appendCarInfo(carInfoDTO);
        return JsonVO.success("添加成功");
    }

    @GetMapping("/getSpaces")
    @ApiOperation("查询车位信息列表")
    @Override
    public JsonVO<PageVO<ParkingSpaceVO>> queryParkingSpaces(ParkingSpaceQuery parkingSpaceQuery) {
        PageVO<ParkingSpaceVO> pageVO = parkingSpaceService.getParkingSpaces(parkingSpaceQuery);
        return JsonVO.success(pageVO);
    }
}
