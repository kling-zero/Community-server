package com.zeroone.star.sccommunity.service.carinfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.carinfo.BuildingOwner;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author night
 * @since 2022-10-21
 */
public interface IBuildingOwnerService extends IService<BuildingOwner> {

    /**
     * 查询用户的小区ID
     * @param userId 用户ID
     * @return 小区ID
     */
    String getCommunityId(String userId);
}
