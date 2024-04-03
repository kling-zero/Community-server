package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.propertyrightregistration.UpdatePPRDetailDTO;

import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.UpdatePPRDetail;
import com.zeroone.star.sccommunity.mapper.prrmanagement.UpdatePPRDetailMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IUpdatePPRDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePPRDetailImpl extends ServiceImpl<UpdatePPRDetailMapper, UpdatePPRDetail> implements IUpdatePPRDetailService {

    @Autowired
    UpdatePPRDetailMapper mapper;
    @Autowired
    IUpdatePPRDetailService service;
    @Override
    public void updateDetail(UpdatePPRDetailDTO condition) {
        UpdatePPRDetail updateDetail = new UpdatePPRDetail();
        UpdateWrapper<UpdatePPRDetail> wrapper = new UpdateWrapper<>();
        wrapper.eq("prrd_id", condition.getPrrdId());
        wrapper.eq("securities", condition.getSecurities());
        //securities材料类型   001身份证   002购房合同   003维修基金(isTrue)   004契税(isTrue)
        PRRDetailVO prrDetailVO = new PRRDetailVO();
        if (condition.getSecurities().equals("维修基金")){
            prrDetailVO.setIsTrue(condition.getIsTrue());
            updateDetail.setSecurities("003");
            updateDetail.setRepairUrl(condition.getRepairUrl());
        }
        else if(condition.getSecurities().equals("契税")){
            prrDetailVO.setIsTrue(condition.getIsTrue());
            updateDetail.setSecurities("004");
            updateDetail.setDeedTaxUrl(condition.getDeedTaxUrl());
        }else{
            prrDetailVO.setIsTrue("");
            if(condition.getSecurities().equals("身份证")){
                updateDetail.setSecurities("001");
                updateDetail.setIdCardUrl(condition.getIdCardUrl());
            }else{
                updateDetail.setSecurities("002");
                updateDetail.setHousePurchaseUrl(condition.getHousePurchaseUrl());
            }
        }
        prrDetailVO.setSecurities(condition.getSecurities());


        service.update(updateDetail, wrapper);
    }
}
