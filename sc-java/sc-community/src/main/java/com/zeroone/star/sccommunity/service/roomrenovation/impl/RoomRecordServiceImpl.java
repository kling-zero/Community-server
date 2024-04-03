package com.zeroone.star.sccommunity.service.roomrenovation.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.roomRenovation.RoomBasicDTO;
import com.zeroone.star.project.query.community.roomRenovation.RecordRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.DetailRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.RecordRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomBasic;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomDetail;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomRecord;
import com.zeroone.star.sccommunity.mapper.roomrenovation.RoomBasicMapper;
import com.zeroone.star.sccommunity.mapper.roomrenovation.RoomRecordMapper;
import com.zeroone.star.sccommunity.service.roomrenovation.RoomRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoomRecordServiceImpl extends ServiceImpl<RoomRecordMapper, RoomRecord> implements RoomRecordService {
    @Resource
    private RoomRecordMapper roomRecordMapper;
    @Resource
    private RoomBasicMapper roomBasicMapper;

    @Override
    public void deleteRecord(RecordRenovationQuery condition) {
        LambdaQueryWrapper<RoomRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoomRecord::getRId, condition.getRId());
        roomRecordMapper.delete(wrapper);
    }

    @Override
    public void queryRecordDetail() {

    }

    @Override
    public PageVO<RecordRenovationVO> queryRecordAllById(RecordRenovationQuery condition) {
        //构建分页对象
        Page<RoomRecord> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        //构建条件对象
        LambdaQueryWrapper<RoomRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomRecord::getRId, condition.getRId());
        //执行分页查询
        Page<RoomRecord> pages = roomRecordMapper.selectPage(page, queryWrapper);
//        for (RoomRecord record:pages.getRecords()) {
//            LambdaQueryWrapper<RoomBasic> queryWrapper2 = new LambdaQueryWrapper<>();
//            queryWrapper2.eq(RoomBasic::getRId, record.getRId());
//            record.get
//
//
//        }


        return PageVO.create(pages, RecordRenovationVO.class);

    }


}
