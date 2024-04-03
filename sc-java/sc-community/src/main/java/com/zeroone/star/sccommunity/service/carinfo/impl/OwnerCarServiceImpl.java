package com.zeroone.star.sccommunity.service.carinfo.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.transactions.carinfo.CarInfoDTO;
import com.zeroone.star.project.query.community.transactions.carinfo.CarInfoQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.CarInfoVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.CarVO;
import com.zeroone.star.sccommunity.entity.carinfo.BuildingOwner;
import com.zeroone.star.sccommunity.entity.carinfo.OwnerCar;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingArea;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingSpace;
import com.zeroone.star.sccommunity.mapper.carinfo.OwnerCarMapper;
import com.zeroone.star.sccommunity.service.carinfo.IBuildingOwnerService;
import com.zeroone.star.sccommunity.service.carinfo.IOwnerCarService;
import com.zeroone.star.sccommunity.service.carinfo.IParkingAreaService;
import com.zeroone.star.sccommunity.service.carinfo.IParkingSpaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author night
 * @since 2022-10-20
 */
@Service
public class OwnerCarServiceImpl extends ServiceImpl<OwnerCarMapper, OwnerCar> implements IOwnerCarService {

    @Autowired
    private IParkingSpaceService psService;
    @Autowired
    private IParkingAreaService paService;
    @Autowired
    private IBuildingOwnerService buildingOwnerService;

    /**
     * 查询车辆信息列表
     * @param carInfoQuery 业主ID
     * @return 车辆信息列表
     */
    @Override
    public PageVO<CarInfoVO> getCarInfos(CarInfoQuery carInfoQuery) {
        //查询对应业主ID的所有车辆
        Page<OwnerCar> page = new Page<>(carInfoQuery.getPageIndex(), carInfoQuery.getPageSize());
        LambdaQueryWrapper<OwnerCar> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OwnerCar::getOwnerId, carInfoQuery.getOwnerId());
        Page<OwnerCar> ownerCarPage = baseMapper.selectPage(page, queryWrapper);

        //用车位ID查询车位信息, 用业主ID查询业主姓名, 把状态改为对应字符串返回
        for (OwnerCar ownerCar : ownerCarPage.getRecords()) {
            //用ps_id查询车位信息
            LambdaQueryWrapper<ParkingSpace> psQuery = new LambdaQueryWrapper<>();
            psQuery.eq(ParkingSpace::getPsId, ownerCar.getPsId());
            ParkingSpace parkingSpace = psService.getOne(psQuery);

            //使用车位信息里的pa_id查询停车场信息
            LambdaQueryWrapper<ParkingArea> paQuery = new LambdaQueryWrapper<>();
            paQuery.eq(ParkingArea::getPaId, parkingSpace.getPaId());
            ParkingArea parkingArea = paService.getOne(paQuery);

            //记录车位信息
            StringBuilder spaceStr = new StringBuilder();
            //把编号信息设置到返回对象里
            spaceStr.append(parkingArea.getNum() + "车场");
            spaceStr.append(parkingSpace.getNum() + "车位");
            ownerCar.setParking(spaceStr.toString());

            //用owner_id查询业主姓名
            LambdaQueryWrapper<BuildingOwner> boQuery = new LambdaQueryWrapper<>();
            boQuery.eq(BuildingOwner::getOwnerId, ownerCar.getOwnerId());
            BuildingOwner owner = buildingOwnerService.getOne(boQuery);
            ownerCar.setOwner(owner.getName());

            //把state改为文字说明
            String state = ownerCar.getState();
            if ("1001".equals(state)) {
                ownerCar.setState("正常状态");
            } else if ("2002".equals(state)) {
                ownerCar.setState("车位释放欠费状态");
            } else {
                ownerCar.setState("车位释放");
            }
        }

        return PageVO.create(ownerCarPage, CarInfoVO.class);
    }

    /**
     * 释放车位
     * @param carId 车辆ID
     */
    @Override
    public void modifyState(String carId) {
        //把状态设置为车位释放(3003)  如果已经是3003则不用再次释放，这个逻辑在前端页面可以判断，后端省略
        LambdaUpdateWrapper<OwnerCar> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(OwnerCar::getCarId, carId).set(OwnerCar::getState, "3003");
        baseMapper.update(null, updateWrapper);
    }


    /**
     * 修改车辆信息
     * @param carInfoDTO 车辆DTO
     */
    @Override
    public void modifyCarInfo(CarInfoDTO carInfoDTO) {

        //把传过来的字符串转换成code
        String carTypeCd = carInfoDTO.getCarTypeCd();
        if ("是".equals(carTypeCd)) {
            carInfoDTO.setCarTypeCd("1001");
        } else {
            carInfoDTO.setCarTypeCd("1002");
        }

        String carType = carInfoDTO.getCarType();
        if ("家用汽车".equals(carType)) {
            carInfoDTO.setCarType("9901");
        } else if ("客车".equals(carType)) {
            carInfoDTO.setCarType("9902");
        } else {
            carInfoDTO.setCarType("9903");
        }

        //设置更新条件
        LambdaUpdateWrapper<OwnerCar> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OwnerCar::getCarId, carInfoDTO.getCarId());
        updateWrapper.set(OwnerCar::getCarBrand, carInfoDTO.getCarBrand());
        updateWrapper.set(OwnerCar::getCarColor, carInfoDTO.getCarColor());
        updateWrapper.set(OwnerCar::getCarNum, carInfoDTO.getCarNum());
        updateWrapper.set(OwnerCar::getCarType, carInfoDTO.getCarType());
        updateWrapper.set(OwnerCar::getEndTime, carInfoDTO.getEndTime());
        updateWrapper.set(OwnerCar::getStartTime, carInfoDTO.getStartTime());
        updateWrapper.set(OwnerCar::getRemark, carInfoDTO.getRemark());

        this.update(updateWrapper);
    }

    /**
     * 删除车辆信息
     * @param carId 车辆ID
     */
    @Override
    public void deleteCarInfo(String carId) {
        this.removeById(carId);
    }

    /**
     * 新增车辆信息
     * @param carInfoDTO 车辆DTO
     */
    @Override
    public void appendCarInfo(CarInfoDTO carInfoDTO) {
        //字符串信息转换为对应code
        String carType = carInfoDTO.getCarType();
        if ("家用汽车".equals(carType)) {
            carInfoDTO.setCarType("9901");
        } else if ("客车".equals(carType)) {
            carInfoDTO.setCarType("9902");
        } else {
            carInfoDTO.setCarType("9903");
        }

        String carTypeCd = carInfoDTO.getCarTypeCd();
        if ("是".equals(carTypeCd)) {
            carInfoDTO.setCarTypeCd("1001");
        } else {
            carInfoDTO.setCarTypeCd("1002");
        }

        //转换为DO
        OwnerCar ownerCar = new OwnerCar();
        BeanUtils.copyProperties(carInfoDTO, ownerCar);
        ownerCar.setState("1001");

        baseMapper.insert(ownerCar);
    }

    /**
     * 获取用户所有车辆
     * @param memberId 成员ID
     * @return 车辆集合
     */
    @Override
    public List<CarVO> getAllCar(String memberId) {
        //获取业主
        LambdaQueryWrapper<BuildingOwner> buildingQuery = new LambdaQueryWrapper<>();
        buildingQuery.eq(BuildingOwner::getMemberId, memberId);
        BuildingOwner owner = buildingOwnerService.getOne(buildingQuery);

        //获取业主车辆
        LambdaQueryWrapper<OwnerCar> carQuery = new LambdaQueryWrapper<>();
        carQuery.eq(OwnerCar::getOwnerId, owner.getOwnerId());
        List<OwnerCar> ownerCars = baseMapper.selectList(carQuery);

        //转成VO
        if (ownerCars != null) {
            List<CarVO> cars = ownerCars.stream().map((car) -> {
                CarVO carVO = new CarVO();
                carVO.setCarId(car.getCarId());
                carVO.setCarName(car.getCarNum());
                return carVO;
            }).collect(Collectors.toList());

            return cars;
        }
        return null;
    }
}
