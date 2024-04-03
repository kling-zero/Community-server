package com.zeroone.star.project.management;

import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.management.CityAreaVO;

import java.util.List;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-23 9:45
 * @Version: 1.0
 * @Description: 对城市列表的操作
 */

public interface CityAreaApi {

    /**
     * 获取城市列表
     * @param cityAreaQuery
     * @return 城市列表
     */
    JsonVO<List<CityAreaVO>> getAreas(CityAreaQuery cityAreaQuery);

}