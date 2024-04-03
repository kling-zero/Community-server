package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.buildingfee.MRQDataQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.MRQDataVO;
import com.zeroone.star.sccommunity.entity.buildingfee.MeterWater;
import com.zeroone.star.sccommunity.mapper.buildingfee.MeterWaterMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IMeterWaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Service
public class MeterWaterServiceImpl extends ServiceImpl<MeterWaterMapper, MeterWater> implements IMeterWaterService {

    /**
     * 查询上期度数
     * @param condition 查询条件
     * @return 上期度数和上期检查时间的vo
     */
    @Override
    public PageVO<MRQDataVO> getLastInfo(MRQDataQuery condition) {
        //这里不需要分页，但是文档里用的page所以查一页一条
        Page<MeterWater> page = new Page<>(1,1);
        LambdaQueryWrapper<MeterWater> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MeterWater::getCommunityId, condition.getCommunityId())
                .eq(MeterWater::getMeterType, condition.getMeterType())
                .eq(MeterWater::getObjType, condition.getObjType())
                .eq(MeterWater::getObjId, condition.getObjId())
                .eq(MeterWater::getStatusCd, "0");
        Page<MeterWater> meterWaters = baseMapper.selectPage(page, queryWrapper);

        return PageVO.create(meterWaters, MRQDataVO.class);
    }
}
