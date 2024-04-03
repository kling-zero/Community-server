package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.structure.FeeDetail;
import com.zeroone.star.sccommunity.mapper.structure.FeeDetailMapper;
import com.zeroone.star.sccommunity.service.structure.IFeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * 根据业主id查询欠款
 */
@Service
public class FeeDetailServiceImpl extends ServiceImpl<FeeDetailMapper, FeeDetail> implements IFeeDetailService {
    @Autowired
    FeeDetailMapper feeDetailMapper;
    @Override
    public FeeDetail selectById(String ownerId) {
        QueryWrapper<FeeDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("owner_id",ownerId);
        FeeDetail feeDetail = feeDetailMapper.selectOne(wrapper);
        return feeDetail;
    }
}
