package com.zeroone.star.sccommunity.service.houseproperty.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.myCommunity.SavaHandOverDTO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomAttrDto;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomCreateFeeAddVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.Rooms;
import com.zeroone.star.sccommunity.entity.houseproperty.*;
import com.zeroone.star.sccommunity.mapper.houseproperty.*;
import com.zeroone.star.sccommunity.mapper.ownermember.BuildingOwnerMapper;
import com.zeroone.star.sccommunity.service.houseproperty.ISaveHandOverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/24
 */
@Service
public class SaveHandOverServiceImp extends ServiceImpl<SaveHandOverMapper, SaveHandOver> implements ISaveHandOverService {
    @Autowired
    HousePayFeeConfigMapper payFeeConfigMapper;
    @Autowired
    HouseBuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    BuildingUnitMapper buildingUnitMapper;
    @Autowired
    HouseBusinessFloorMapper businessFloorMapper;
    @Autowired
    BuildingOwnerAttrMapper buildingOwnerAttrMapper;
    @Override
    public PageVO saveHandOver(SavaHandOverDTO data) {
        Page<SaveHandOver> page = new Page<>();
        System.out.println(data.toString());
        for (RoomCreateFeeAddVO  roomCreateFeeAdd:
                data.getFees()) {
            PayFeeConfig payFeeConfig = new PayFeeConfig();
            payFeeConfig.setCreateTime(LocalDateTime.now());
            payFeeConfig.setAdditionalAmount(roomCreateFeeAdd.getAdditionalAmount());
            payFeeConfig.setBillType(roomCreateFeeAdd.getBillType());
            payFeeConfig.setBillTypeName(roomCreateFeeAdd.getBillTypeName());
            payFeeConfig.setComputingFormula(roomCreateFeeAdd.getComputingFormula());
            payFeeConfig.setComputingFormulaText(roomCreateFeeAdd.getComputingFormulaText());
            payFeeConfig.setConfigId(roomCreateFeeAdd.getConfigId());
            payFeeConfig.setDeductFrom(roomCreateFeeAdd.getDeductFrom());
            payFeeConfig.setEndTime(roomCreateFeeAdd.getEndTime());
            payFeeConfig.setFeeFlag(roomCreateFeeAdd.getFeeFlag());
            payFeeConfig.setFeeTypeCd(roomCreateFeeAdd.getFeeTypeCd());
            payFeeConfig.setIsDefault(roomCreateFeeAdd.getIsDefault());
            payFeeConfig.setPaymentCd(roomCreateFeeAdd.getPaymentCd());
            payFeeConfig.setPaymentCycle(roomCreateFeeAdd.getPaymentCycle());
            payFeeConfig.setSquarePrice(roomCreateFeeAdd.getSquarePrice());
            payFeeConfig.setStartTime(roomCreateFeeAdd.getStartTime());
            payFeeConfig.setCommunityId(data.getCommunityId());
            payFeeConfigMapper.insert(payFeeConfig);
        }
        PageVO<Object> pageVO = new PageVO<>();
        BeanUtil.copyProperties(page,PageVO.class);
        return pageVO;
    }
}
