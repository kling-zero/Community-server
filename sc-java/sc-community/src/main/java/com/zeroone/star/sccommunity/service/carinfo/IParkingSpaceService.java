package com.zeroone.star.sccommunity.service.carinfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.carinfo.ParkingSpaceQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.ParkingSpaceVO;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingSpace;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author night
 * @since 2022-10-20
 */
public interface IParkingSpaceService extends IService<ParkingSpace> {

    /**
     * 查询车位信息列表
     * @param parkingSpaceQuery 车位信息查询条件
     * @return 车位信息列表
     */
    PageVO<ParkingSpaceVO> getParkingSpaces(ParkingSpaceQuery parkingSpaceQuery);
}
