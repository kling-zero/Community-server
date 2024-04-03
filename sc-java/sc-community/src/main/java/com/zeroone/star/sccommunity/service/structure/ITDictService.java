package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommunity.entity.structure.TDict;

public interface ITDictService extends IService<TDict> {
    TDict selectByStatus(String status, String tableName, String tableColumns);
}
