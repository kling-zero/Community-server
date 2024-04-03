package com.zeroone.star.project.management;

import com.zeroone.star.project.dto.management.UpdatePropertyDTO;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.dto.management.PropertyStateDTO;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.management.PropertyVO;
import com.zeroone.star.project.dto.management.PropertyDTO;

import java.util.List;


/**
 * @Author: j4
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-13 8:32
 * @Version: 1.0
 * @Description: 物业数据管理接口定义
 */

public interface PropertyApi {

    /**
     * 条件查询 物业
     * @param condition 查询条件
     * @return 条件查询的结果，也需要分页
     */
    JsonVO<PageVO<PropertyVO>> queryByCondition(PropertyQuery condition);

    /**
     * 条件查询 某物业所管理的小区列表
     * @param communityQuery 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<SCommunityVO>> queryBelongingCommunities(CommunityQuery communityQuery);

    /**
     * 添加物业
     * @param propertyDTO 物业信息
     * @return 查询结果
     */
    JsonVO<String> insertProperty(PropertyDTO propertyDTO);

    /**
     * 修改物业信息
     * @param updatePropertyDTO 物业信息
     * @return 查询结果
     */
    JsonVO<String> updatePropertyByID(UpdatePropertyDTO updatePropertyDTO);

    /**
     * 物业公司添加小区
     * @param propertyDTO 小区功能信息
     * @return  添加结果
     */
    JsonVO<String> propertyInsertCommunity(PropertyDTO propertyDTO);

    /**
     * 重置物业密码
     * @param propertyDTO 账户信息
     * @return 重置结果
     */
    JsonVO<PropertyVO> resetPwd(PropertyDTO propertyDTO);

    /**
     * 删除物业公司
     * @param storeId 物业公司id
     * @return
     */
    JsonVO<String> removeById(String storeId);

    /**
     * 限制物业登录
     * @param propertyStateDTO 物业公司登录状态信息
     * @return
     */
    JsonVO<String> updateRestrictLogin(PropertyStateDTO propertyStateDTO);

    /**
     * 物业退出小区
     * @return
     */
    JsonVO<String> quitCommunity(CommunityQuery communityQuery);

    /**
     * 修改小区功能
     * @param propertyDTO
     * @return
     */
    JsonVO<String> updateMenu(PropertyDTO propertyDTO);

    /**
     * 回显没有物业归属的小区
     *
     * @return 查询结果(因为是下拉菜单应该不需要分页)
     */
    JsonVO<List<SCommunityVO>> queryAccessibleCommunities();
}