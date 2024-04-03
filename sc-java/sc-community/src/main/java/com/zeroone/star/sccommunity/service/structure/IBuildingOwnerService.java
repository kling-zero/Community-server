package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.structure.BuildingOwner;

public interface IBuildingOwnerService extends IService<BuildingOwner> {
    BuildingOwner selectById(String ownerId);

    BuildingOwner selectByUserId(String userId);
}
