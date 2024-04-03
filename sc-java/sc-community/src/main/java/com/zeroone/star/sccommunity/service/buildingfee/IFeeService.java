package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.Fees;

import java.util.List;

public interface IFeeService extends IService<Fees> {
    FeesVO selectOne(OwnerAccountQuery condition);

    //通过user_id集合获取该用户的所有feed_id集合
    List<String> selectByUserId(List<String> userId);

    //通过feed_id来获取user_id,一个fee_id只对应一个user_id
    String selectByFeeId(String fee_id);
}
