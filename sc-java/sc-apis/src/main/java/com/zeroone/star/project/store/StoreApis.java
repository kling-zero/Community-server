package com.zeroone.star.project.store;

import com.zeroone.star.project.query.store.CommunityQuery;
import com.zeroone.star.project.query.store.StoreAdminQuery;
import com.zeroone.star.project.query.store.StoreQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.homepage.CommunityVO;
import com.zeroone.star.project.vo.store.*;
import java.util.List;

/**
 * @Description 商户API定义
 * @Author j3小组-黑夜
 */
public interface StoreApis {

    /**
     * 查询条件-获取商户类型列表
     * @return 商户类型集合
     */
    JsonVO<List<String>> getAllStoreTypes();

    /**
     * 根据查询条件和页数 获取商户-商户信息
     * @param storeQuery 包含分页信息和查询商户的3个查询条件
     * @return 商户信息集合
     */
    JsonVO<PageVO<StoreVO>> getStoresByPageAndCondition(StoreQuery storeQuery);

    /**
     * 获取商户-商户管理员
     * @param storeAdminQuery 包含分页信息和查询管理员的3个查询条件
     * @return 商户管理员集合
     */
    JsonVO<PageVO<StoreAdminVO>> getStoreAdminsByPageAndCondition(StoreAdminQuery storeAdminQuery);

    /**
     * 获取指定物业的隶属小区
     * @param communityQuery 物业ID
     * @return 隶属小区分页对象
     */
    JsonVO<PageVO<CommunitiesVO>> queryAllSubordinationCommunities(CommunityQuery communityQuery);

    /**
     * 限制指定商户登录
     * @param id 物业ID
     * @return 字符串显示结果
     */
    JsonVO<String> modifyRestrictLoginById(String id);
}
