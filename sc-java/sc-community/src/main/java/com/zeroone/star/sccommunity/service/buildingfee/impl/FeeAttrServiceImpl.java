package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeAttr;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.mapper.buildingfee.FeeAttrMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeAttrService;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeAttrServiceImpl extends ServiceImpl<FeeAttrMapper, FeeAttr> implements IFeeAttrService {
    @Autowired
    FeeAttrMapper feeAttrMapper;
    @Autowired
    ITDictService itDictService;

    @Override
    public List<FeeAttr> selectByFeeId(String feeId) {
        QueryWrapper<FeeAttr> wrapper = new QueryWrapper<>();
        wrapper.eq("fee_id",feeId);
        List<FeeAttr> feeAttrs = feeAttrMapper.selectList(wrapper);
        for (FeeAttr fee:feeAttrs) {
            TDict tDict = itDictService.selectByStatus(fee.getSpecCd(), "pay_fee_attrs", "spec_cd");
            if (tDict !=null){
                fee.setSpecCdName(tDict.getName());
            }else {
                fee.setSpecCdName("");
            }
        }
        return feeAttrs;
    }
}
