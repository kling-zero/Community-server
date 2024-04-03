package com.zeroone.star.sccommunity.service.carinfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.transactions.carinfo.CarInfoDTO;
import com.zeroone.star.project.query.community.transactions.carinfo.CarInfoQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.CarInfoVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.CarVO;
import com.zeroone.star.sccommunity.entity.carinfo.OwnerCar;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author night
 * @since 2022-10-20
 */
public interface IOwnerCarService extends IService<OwnerCar> {

    /**
     * 查询车辆信息列表
     * @param carInfoQuery 业主ID
     * @return 车辆信息列表
     */
    PageVO<CarInfoVO> getCarInfos(CarInfoQuery carInfoQuery);

    /**
     * 释放车位
     * @param carId 车辆ID
     */
    void modifyState(String carId);

    /**
     * 修改车辆信息
     * @param carInfoDTO 车辆DTO
     */
    void modifyCarInfo(CarInfoDTO carInfoDTO);

    /**
     * 删除车辆信息
     * @param carId 车辆ID
     */
    void deleteCarInfo(String carId);

    /**
     * 新增车辆信息
     * @param carInfoDTO 车辆DTO
     */
    void appendCarInfo(CarInfoDTO carInfoDTO);

    /**
     * 获取用户所有车辆
     * @param memberId 成员ID
     * @return 车辆集合
     */
    List<CarVO> getAllCar(String memberId);
}
