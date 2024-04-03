package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.propertyrightregistration.SavePRRDTO;
import com.zeroone.star.sccommunity.entity.prrmanagement.*;
import com.zeroone.star.sccommunity.mapper.prrmanagement.*;
import com.zeroone.star.sccommunity.service.prrmanagement.ISavePRRService;
import com.zeroone.star.sccommunity.service.prrmanagement.IUpdatePPRDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Random;

@Service
public class SavePRRImpl extends ServiceImpl<SavePRRMapper, SavePRR> implements ISavePRRService {

    @Autowired
    private SavePRRMapper mapper;
    @Autowired
    ISavePRRService service;
    @Autowired
    IUpdatePPRDetailService updateDetailService;
    @Autowired
    SavePRRDetailMapper savePRRDetailMapper;
    @Autowired
    SaveBPRRMapper saveBPRRMapper;

    @Autowired
    SaveBRMapper saveBRMapper;

    @Autowired
    SaveBUMapper saveBUMapper;


    @Override
    public boolean save(SavePRRDTO condition) {
        SavePRR savePRR = new SavePRR();
        savePRR.setPrrId(condition.getPrrId());
        savePRR.setRoomId(condition.getRoomId());
        savePRR.setName(condition.getName());
        savePRR.setLink(condition.getLink());
        savePRR.setIdCard(condition.getIdCard());
        savePRR.setAddress(condition.getAddress());
//        savePRR.setState(condition.getState());
//        审核状态  0 未审核  1 审核通过  2 审核拒绝
        savePRR.setState(condition.getState()=="未审核"?"0":condition.getState()=="审核通过"?"1":condition.getState()=="审核拒绝"?"2":"1");

        savePRR.setCommunityId(condition.getCommunityId());
        int insert = mapper.insert(savePRR);

        SavePRRDetail savePRRDetail = new SavePRRDetail();
        savePRRDetail.setPrrdId(condition.getPrrId());
        savePRRDetail.setPrrId(condition.getPrrId());
//        savePRRDetail.setIsTrue(condition.getIsTrue());
        String isTrue = condition.getIsTrue();
        savePRRDetail.setIsTrue(isTrue=="true"?"是":"否");
        int insert1 = savePRRDetailMapper.insert(savePRRDetail);

        SaveBPRR saveBPRR = new SaveBPRR();
        saveBPRR.setPrrId(condition.getPrrId());
        saveBPRR.setBId(condition.getPrrId());
        saveBPRR.setRoomId(condition.getRoomId());
        saveBPRR.setName(condition.getName());
        saveBPRR.setLink(condition.getLink());
        saveBPRR.setIdCard(condition.getIdCard());
        saveBPRR.setAddress(condition.getAddress());
//        saveBPRR.setState(condition.getState());
//        审核状态  0 未审核  1 审核通过  2 审核拒绝
        saveBPRR.setState(condition.getState()=="未审核"?"0":condition.getState()=="审核通过"?"1":condition.getState()=="审核拒绝"?"2":"1");
        saveBPRR.setCommunityId(condition.getCommunityId());
        int insert2 = saveBPRRMapper.insert(saveBPRR);

        SaveBR saveBR = new SaveBR();
        saveBR.setRoomId(condition.getRoomId());
        saveBR.setBId(condition.getPrrId());
        saveBR.setRoomNum(condition.getRoomNum());
        saveBR.setUnitId(condition.getUnitId());
        saveBR.setState(condition.getState());
        saveBR.setCommunityId(condition.getCommunityId());
        int insert3 = saveBRMapper.insert(saveBR);

        SaveBU saveBU = new SaveBU();
        saveBU.setUnitId(condition.getUnitId());
        saveBU.setUnitNum(condition.getUnitNum());
        saveBU.setFloorId(condition.getFloorId());
        int insert4 = saveBUMapper.insert(saveBU);

        return insert==insert1?(insert2==insert1?(insert2==insert3?insert3==insert4:false):false):false;
    }
}
