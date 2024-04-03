package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.structure.BusinessFloor;

public interface IBusinessFloorService extends IService<BusinessFloor> {
    //根据userId查询
    BusinessFloor selectById(String userid);

    BusinessFloor selectByFloorId(String FloorId);
}
