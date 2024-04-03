package com.zeroone.star.project.community.transactions.carinfo;

import com.zeroone.star.project.dto.community.transactions.carinfo.CarInfoDTO;
import com.zeroone.star.project.query.community.transactions.carinfo.CarInfoQuery;
import com.zeroone.star.project.query.community.transactions.carinfo.ParkingSpaceQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.CarInfoVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.ParkingSpaceVO;

/**
 * 车辆信息接口
 */
public interface CarInfoApis {

    /**
     * 查询车辆信息
     * @param carInfoQuery 业主ID
     * @return 车辆信息分页对象
     */
    JsonVO<PageVO<CarInfoVO>> queryCarinfos(CarInfoQuery carInfoQuery);

    /**
     * 释放车位 = 修改车状态
     * @param carId 车辆ID
     * @return 结果的字符串
     */
    JsonVO<String> modifyState(String carId);

    /**
     * 修改车辆信息
     * @param carInfoDTO 车辆DTO
     * @return 成否字符串
     */
    JsonVO<String> modifyInfo(CarInfoDTO carInfoDTO);

    /**
     * 删除指定车辆信息
     * @param carId 车辆ID
     * @return 成否字符串
     */
    JsonVO<String> deleteInfo(String carId);

    /**
     * 新增车辆信息
     * @param carInfoDTO 车辆DTO
     * @return 成否字符串
     */
    JsonVO<String> addInfo(CarInfoDTO carInfoDTO);

    /**
     * 查询车位
     * @param parkingSpaceQuery 停车位查询条件
     * @return 停车位分页对象
     */
    JsonVO<PageVO<ParkingSpaceVO>> queryParkingSpaces(ParkingSpaceQuery parkingSpaceQuery);
}
