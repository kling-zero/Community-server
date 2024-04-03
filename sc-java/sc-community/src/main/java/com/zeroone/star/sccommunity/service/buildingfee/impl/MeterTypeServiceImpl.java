package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.buildingfee.MeterReadingQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.MeterTypesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.MeterType;
import com.zeroone.star.sccommunity.mapper.buildingfee.MeterTypeMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IMeterTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Service
public class MeterTypeServiceImpl extends ServiceImpl<MeterTypeMapper, MeterType> implements IMeterTypeService {

    /**
     * 获取抄表类型
     * @param condition 查询条件--小区ID
     * @return 抄表类型分页对象
     */
    @Override
    public PageVO<MeterTypesVO> queryAll(MeterReadingQuery condition) {
        //分页查询
        Page<MeterType> page = new Page<>();
        LambdaQueryWrapper<MeterType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MeterType::getCommunityId, condition.getCommunityId());
        Page<MeterType> meterTypePage = baseMapper.selectPage(page, queryWrapper);

        return PageVO.create(meterTypePage, MeterTypesVO.class);
    }
}
