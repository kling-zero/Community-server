package com.zeroone.star.sccommunity.service.houseproperty.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.sccommunity.entity.houseproperty.PayFeeConfig;
import com.zeroone.star.sccommunity.entity.houseproperty.RoomCreateFeeAdd;
import com.zeroone.star.sccommunity.mapper.houseproperty.HousePayFeeConfigMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.RoomCreateFeeMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IRoomCreateFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/21
 */
@Service
public class RoomCreateFeeServiceImp extends ServiceImpl<RoomCreateFeeMapper, RoomCreateFeeAdd> implements IRoomCreateFeeService {
    @Autowired
    RoomCreateFeeMapper roomCreateFeeMapper;
    @Autowired
    HousePayFeeConfigMapper payFeeConfigMapper;

    @Override
    public PageVO<RoomCreateFeeAddVO> queryAllRoomsFee(RoomCreateFeeAddQuery query) {
        String communityId = query.getCommunityId();
        Page<PayFeeConfig> page = new Page<>(query.getPageIndex(),query.getPageSize());
        QueryWrapper<PayFeeConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",communityId).eq("fee_type_cd",query.getFeeTypeCd())
                .eq("is_default",query.getIsDefault());
        Page<PayFeeConfig> payFeeConfigPages = payFeeConfigMapper.selectPage(page,wrapper);
        return PageVO.create(payFeeConfigPages,RoomCreateFeeAddVO.class);
    }
}
