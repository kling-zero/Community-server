package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.AcceptHousePropertyQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.AcceptHousePropertyVO;
import com.zeroone.star.sccommunity.entity.houseproperty.AcceptHouseProperty;

public interface IAcceptHousePropertyService extends IService<AcceptHouseProperty> {
    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
   AcceptHousePropertyVO queryOne(AcceptHousePropertyQuery query);
}
