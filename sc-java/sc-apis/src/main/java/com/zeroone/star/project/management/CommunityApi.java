package com.zeroone.star.project.management;

import com.zeroone.star.project.dto.management.CommunityDTO;
import com.zeroone.star.project.dto.management.ModifyCommunityDTO;
import com.zeroone.star.project.dto.management.PropertyDTO;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.CityAreaVO;
import com.zeroone.star.project.vo.management.SCommunityMenuVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import java.util.List;

/**
 * @Author: j4
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 8:32
 * @Version: 1.0
 * @Description: 小区数据管理接口定义
 */

public interface CommunityApi {
    /**
     * 添加小区
     * @param communityDTO 小区信息
     * @return
     */
    JsonVO<String> addCommunity(CommunityDTO communityDTO);

    /**
     * 根据条件返回 小区分页查询结果
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<SCommunityVO>> queryByCondition(CommunityQuery condition);

    /**
     * 修改小区信息
     * @param modifyCommunityDTO 带社区id的小区dto
     * @return
     */
    JsonVO<String> modifyCommunityById(ModifyCommunityDTO modifyCommunityDTO);

    /**
     * 获取小区功能的所有可选项
     * @return
     */
    JsonVO<List<SCommunityMenuVO>> listMenuGroup();

    /**
     * 获取小区已选功能
     * @return
     */
    JsonVO<List<SCommunityMenuVO>> listCommunityMenu(CommunityQuery communityQuery);


}