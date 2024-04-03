package com.zeroone.star.sccommunity.service.roomrenovation.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.roomRenovation.RoomBasicDTO;
import com.zeroone.star.project.query.community.roomRenovation.BasicRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.BasicRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomBasic;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomRecord;
import com.zeroone.star.sccommunity.mapper.roomrenovation.RoomBasicMapper;
import com.zeroone.star.sccommunity.service.roomrenovation.RoomBasicService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomBasicServiceImpl extends ServiceImpl<RoomBasicMapper, RoomBasic> implements RoomBasicService {
    @Resource
    private RoomBasicMapper roomBasicMapper;

    @Override
    public PageVO<BasicRenovationVO> queryAll(BasicRenovationQuery condition) {
        //构建分页对象
        Page<RoomBasic> page = new Page<>(condition.getPageIndex(),condition.getPageSize());
        //构建条件对象
        LambdaQueryWrapper<RoomBasic> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomBasic::getRoomId, condition.getRoomId());
        queryWrapper.eq(RoomBasic::getPersonName, condition.getPersonName());
        queryWrapper.eq(RoomBasic::getPersonTel, condition.getPersonTel());
        queryWrapper.eq(RoomBasic::getCreateTime, condition.getStartTime());
        queryWrapper.eq(RoomBasic::getEndTime, condition.getEndTime());
        queryWrapper.eq(RoomBasic::getIsPostpone, condition.getIsPostpone());
        queryWrapper.eq(RoomBasic::getState, condition.getState());
        queryWrapper.eq(RoomBasic::getRoomName, condition.getRoomName());
        queryWrapper.eq(RoomBasic::getCommunityId, condition.getCommunityId());
        queryWrapper.eq(RoomBasic::getIsPostpone, condition.getIsPostpone());
        //执行分页查询
        Page<RoomBasic> pages =roomBasicMapper.selectPage(page,queryWrapper);
        return PageVO.create(pages,BasicRenovationVO.class);
    }

    @Override
    public void saveBasic(RoomBasicDTO condition) {
        RoomBasic roomBasic = copy(condition);
        roomBasicMapper.insert(roomBasic);
    }

    @Override
    public void deleteBasic(RoomBasicDTO condition) {
        RoomBasic roomBasic = copy(condition);
        roomBasicMapper.deleteById(roomBasic);
    }

    @Override
    public void updateBasic(RoomBasicDTO condition) {
        RoomBasic roomBasic = copy(condition);
        roomBasicMapper.updateById(roomBasic);
    }


    public RoomBasic copy(RoomBasicDTO condition) {
        RoomBasic roomBasic = new RoomBasic();
        roomBasic.setRoomId(condition.getRoomId());
        roomBasic.setPersonMain(condition.getPersonMain());
        roomBasic.setPersonName(condition.getPersonName());
        roomBasic.setPersonTel(condition.getPersonTel());
        roomBasic.setPersonMainTel(condition.getPersonMainTel());
        roomBasic.setCreateTime(condition.getCreateTime());
        roomBasic.setEndTime(condition.getEndTime());
        roomBasic.setIsPostpone(condition.getIsPostpone());
        roomBasic.setState(condition.getState());
        roomBasic.setRenovationCompany(condition.getRenovationCompany());
        roomBasic.setRoomName(condition.getRoomName());
        roomBasic.setRId(condition.getRId());
        roomBasic.setIsViolation(condition.getIsViolation());
        return roomBasic;
    }

}
