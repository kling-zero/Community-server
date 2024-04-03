package com.zeroone.star.sccommunity.service.roomrenovation.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.roomRenovation.DetailRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.BasicRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.DetailRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomBasic;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomDetail;
import com.zeroone.star.sccommunity.mapper.roomrenovation.RoomDetailMapper;
import com.zeroone.star.sccommunity.service.roomrenovation.RoomDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDetailServiceImpl extends ServiceImpl<RoomDetailMapper, RoomDetail> implements RoomDetailService {

    @Resource
    private RoomDetailMapper roomDetailMapper;

    @Override
    public PageVO<DetailRenovationVO> queryDetailAllById(DetailRenovationQuery condition) {

        //构建分页对象
        Page<RoomDetail> page = new Page<>(condition.getPageIndex(),condition.getPageSize());
        //构建条件对象
        LambdaQueryWrapper<RoomDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomDetail::getCommunityId, condition.getCommunityId());
        queryWrapper.eq(RoomDetail::getRId, condition.getRId());

        //执行分页查询
        Page<RoomDetail> pages =roomDetailMapper.selectPage(page,queryWrapper);
        return PageVO.create(pages, DetailRenovationVO.class);

    }
}
