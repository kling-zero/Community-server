package com.zeroone.star.schp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.vo.homepage.CommunityVO;
import com.zeroone.star.schp.entity.BuildingOwner;
import com.zeroone.star.schp.entity.BuildingRoom;
import com.zeroone.star.schp.entity.OwnerCar;
import com.zeroone.star.schp.entity.ParkingSpace;
import com.zeroone.star.schp.mapper.*;
import com.zeroone.star.schp.service.CommunityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zimei
 * @since 2022-10-19
 */
@Service
public class CommunityInfoServiceImpl implements CommunityInfoService {
    @Autowired
    private BuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    private BuildingRoomMapper buildingRoomMapper;
    @Autowired
    private OwnerCarMapper ownerCarMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private SStoreMapper sStoreMapper;
    @Override
    public CommunityVO listAllCommunityInfo(String id) {

        CommunityVO communityVO = new CommunityVO();

        QueryWrapper<BuildingOwner> buildingOwnerQueryWrapper = new QueryWrapper<>();
        buildingOwnerQueryWrapper.eq("community_id",id);
        communityVO.setHouseholdsNumber(Math.toIntExact(buildingOwnerMapper.selectCount(buildingOwnerQueryWrapper)));

//        没找到表，写的死数据Orz：楼宇数量
        communityVO.setBuildingsNumber(3);

        QueryWrapper<OwnerCar> ownerCarQueryWrapper = new QueryWrapper<>();
        ownerCarQueryWrapper.eq("community_id",id);
        communityVO.setVehiclesNumber(Math.toIntExact(ownerCarMapper.selectCount(ownerCarQueryWrapper)));

        QueryWrapper<ParkingSpace> parkingSpaceQueryWrapper = new QueryWrapper<>();
        parkingSpaceQueryWrapper.eq("community_id",id);
        communityVO.setParkingSpacesNumber(Math.toIntExact(parkingSpaceMapper.selectCount(parkingSpaceQueryWrapper)));

//        商铺数量没有找到对应小区，这里查询的是所有商铺数量
        communityVO.setShopsNumber(Math.toIntExact(sStoreMapper.selectCount(null)));

        QueryWrapper<BuildingRoom> buildingRoomQueryWrapper = new QueryWrapper<>();
        buildingRoomQueryWrapper.eq("community_id",id);
        communityVO.setHousesNumber(Math.toIntExact(buildingRoomMapper.selectCount(buildingRoomQueryWrapper)));

        return communityVO;
    }
}
