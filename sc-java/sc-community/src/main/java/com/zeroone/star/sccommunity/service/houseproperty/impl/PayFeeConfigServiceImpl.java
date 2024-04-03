package com.zeroone.star.sccommunity.service.houseproperty.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.PayFeeConfigQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.PayFeeConfigVO;

import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.sccommunity.entity.houseproperty.BusinessCommunity;
import com.zeroone.star.sccommunity.entity.houseproperty.PayFeeConfig;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBusinessCommunityMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.HousePayFeeConfigMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IPayFeeConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suqier
 * @since 2022-10-21
 */
@Service
public class PayFeeConfigServiceImpl extends ServiceImpl<HousePayFeeConfigMapper, PayFeeConfig> implements IPayFeeConfigService {

    @Autowired
    HousePayFeeConfigMapper payFeeConfigMapper;
    @Autowired
    HouseBusinessCommunityMapper businessCommunityMapper;
    @Override
    public PayFeeConfigVO queryPayFeeConfig(PayFeeConfigQuery query) {
        QueryWrapper<PayFeeConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("config_id",query.getConfigId());
        PayFeeConfig payFeeConfig = payFeeConfigMapper.selectOne(wrapper);
        QueryWrapper<BusinessCommunity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("community_id",payFeeConfig.getCommunityId());
        BusinessCommunity businessCommunity = businessCommunityMapper.selectOne(queryWrapper);
        PayFeeConfigVO payFeeConfigVO = new PayFeeConfigVO();
        payFeeConfigVO.setDescription(payFeeConfig.getDescription());
        payFeeConfigVO.setName(businessCommunity.getName());
        payFeeConfigVO.setStatusCd(payFeeConfig.getStatusCd());
        BeanUtil.copyProperties(payFeeConfig,PayFeeConfigVO.class);
        return payFeeConfigVO;
    }

    @Override
    public PageVO<RoomCreateFeeAddVO> addRoomCreateFee(RoomCreateFeeAddQuery query) {
        Page<PayFeeConfig> page = new Page<>(query.getPageIndex(),query.getPageSize());
        QueryWrapper<PayFeeConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("community_id",query.getCommunityId())
                .eq("fee_type_cd",query.getFeeTypeCd())
                .eq("is_default",query.getIsDefault());
        Page<PayFeeConfig> payFeeConfigs = payFeeConfigMapper.selectPage(page,queryWrapper);
        for (PayFeeConfig payFeeConfig:
             payFeeConfigs.getRecords()) {
            if(payFeeConfig.getBillType().equals("001")){
                payFeeConfig.setBillTypeName("每年1月1日");
            } else if (payFeeConfig.getBillType().equals("002")) {
                payFeeConfig.setBillTypeName("每月1日");
            }else if (payFeeConfig.getBillType().equals("003")) {
                payFeeConfig.setBillTypeName("每日");
            }else {
                payFeeConfig.setBillTypeName(null);
            }
        }
        return PageVO.create(payFeeConfigs,RoomCreateFeeAddVO.class);
    }
}
