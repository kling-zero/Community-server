package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.structure.Unit;

public interface IUnitService extends IService<Unit> {
    Unit selectById(String unitId);

    Unit selectFloorIdByUnitId(String unitId);
}
