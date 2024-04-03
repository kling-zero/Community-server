package com.zeroone.star.sccommunity.service.carinfo.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.carinfo.ParkingSpaceQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.carinfo.ParkingSpaceVO;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingArea;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingSpace;
import com.zeroone.star.sccommunity.mapper.carinfo.ParkingSpaceMapper;
import com.zeroone.star.sccommunity.service.carinfo.IParkingAreaService;
import com.zeroone.star.sccommunity.service.carinfo.IParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author night
 * @since 2022-10-20
 */
@Service
public class ParkingSpaceServiceImpl extends ServiceImpl<ParkingSpaceMapper, ParkingSpace> implements IParkingSpaceService {

    @Autowired
    private IParkingAreaService paService;

    /**
     * 查询车位信息列表
     * @param parkingSpaceQuery 车位信息查询条件
     * @return 车位信息列表
     */
    @Override
    public PageVO<ParkingSpaceVO> getParkingSpaces(ParkingSpaceQuery parkingSpaceQuery) {
        //查询符合条件的停车位
        Page<ParkingSpace> page = new Page<>(parkingSpaceQuery.getPageIndex(), parkingSpaceQuery.getPageSize());
        LambdaQueryWrapper<ParkingSpace> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(parkingSpaceQuery.getSpaceNum())) {
            queryWrapper.eq(ParkingSpace::getNum, parkingSpaceQuery.getSpaceNum());
        }
        Page<ParkingSpace> parkingSpacePage = baseMapper.selectPage(page, queryWrapper);

        List<ParkingSpace> parkingSpaces = parkingSpacePage.getRecords();
        //查询停车位对应的停车场
        for (ParkingSpace ps : parkingSpaces) {
            String paId = ps.getPaId();
            LambdaQueryWrapper<ParkingArea> paQuery = new LambdaQueryWrapper<>();
            paQuery.eq(ParkingArea::getPaId, paId);
            if (!StringUtils.isEmpty(parkingSpaceQuery.getAreaNum())) {
                paQuery.eq(ParkingArea::getNum, parkingSpaceQuery.getAreaNum());
            }
            //如果停车场不存在，说明不符合查询条件
            ParkingArea pa = paService.getOne(paQuery);
            if (pa == null) {
                parkingSpaces.remove(ps);
            } else {
                ps.setParkingArea(pa.getNum());
            }
        }

        //把状态码改为说明文
        for (ParkingSpace ps : parkingSpaces) {
            String state = ps.getState();
            if ("F".equals(state)) {
                ps.setState("空闲");
            } else if ("H".equals(state)) {
                ps.setState("出租");
            } else {
                ps.setState("出售");
            }
        }

        parkingSpacePage.setRecords(parkingSpaces);
        return PageVO.create(parkingSpacePage, ParkingSpaceVO.class);
    }
}
