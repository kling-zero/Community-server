package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.zeroone.star.management.entity.CityArea;
import com.zeroone.star.management.mapper.CityAreaMapper;
import com.zeroone.star.management.service.ICityAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.vo.management.CityAreaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2022-10-23
 */
@Service
public class CityAreaServiceImpl extends ServiceImpl<CityAreaMapper, CityArea> implements ICityAreaService {

    @Autowired
    CityAreaMapper cityAreaMapper;

    @Override
    public List<CityAreaVO> getAreas(CityAreaQuery cityAreaQuery) {
        LambdaQueryWrapper<CityArea> cityAreaQueryWrapper = new LambdaQueryWrapper<>();
        cityAreaQueryWrapper.eq(CityArea::getAreaLevel, cityAreaQuery.getAreaLevel())
                .eq(CityArea::getParentAreaCode, cityAreaQuery.getParentAreaNode());
        List<CityArea> cityAreas = cityAreaMapper.selectList(cityAreaQueryWrapper);
        //重新封装对象
        List<CityAreaVO> vos = new ArrayList<>();
        for (CityArea cityArea : cityAreas) {
            CityAreaVO cityAreaVO = new CityAreaVO();
            cityAreaVO.setId(cityArea.getId());
            cityAreaVO.setAreaCode(cityArea.getAreaCode());
            cityAreaVO.setAreaName(cityArea.getAreaName());
            cityAreaVO.setAreaLevel(cityArea.getAreaLevel());
            cityAreaVO.setParentAreaCode(cityArea.getParentAreaCode());
            cityAreaVO.setParentAreaName(cityArea.getParentAreaName());
            cityAreaVO.setLon(cityArea.getLon());
            cityAreaVO.setLat(cityArea.getLat());
            vos.add(cityAreaVO);
        }
        return vos;
    }
}
