package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.OwnersQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.OwnersVO;
import com.zeroone.star.sccommunity.entity.houseproperty.Owners;

public interface IOwnersService extends IService<Owners> {

    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<OwnersVO> queryAllOwners(OwnersQuery query);
}
