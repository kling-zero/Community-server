package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.CityArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.vo.management.CityAreaVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2022-10-23
 */
public interface ICityAreaService extends IService<CityArea> {

    /**
     * 获取城市列表
     * @param cityAreaQuery 城市询条件
     * @return 城市列表
     */
    List<CityAreaVO> getAreas(CityAreaQuery cityAreaQuery);

}
