package com.zeroone.star.sccommunity.service.carinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.carinfo.BuildingOwner;
import com.zeroone.star.sccommunity.mapper.carinfo.CarBuildingOwnerMapper;
import com.zeroone.star.sccommunity.service.carinfo.IBuildingOwnerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author night
 * @since 2022-10-21
 */
@Service
public class CarBuildingOwnerServiceImpl extends ServiceImpl<CarBuildingOwnerMapper, BuildingOwner> implements IBuildingOwnerService {

    /**
     * 查询用户的小区ID
     * @param userId 用户ID
     * @return 小区ID
     */
    @Override
    public String getCommunityId(String userId) {
        LambdaQueryWrapper<BuildingOwner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BuildingOwner::getUserId, userId);
        BuildingOwner buildingOwner = baseMapper.selectOne(queryWrapper);
        if (buildingOwner != null) {
            return buildingOwner.getCommunityId();
        }
        return null;
    }
}
