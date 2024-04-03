package com.zeroone.star.scstore.service;

import com.zeroone.star.project.query.store.CommunityQuery;
import com.zeroone.star.project.query.store.StoreAdminQuery;
import com.zeroone.star.project.query.store.StoreQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.homepage.CommunityVO;
import com.zeroone.star.project.vo.store.CommunitiesVO;
import com.zeroone.star.project.vo.store.StoreAdminVO;
import com.zeroone.star.project.vo.store.StoreVO;
import com.zeroone.star.scstore.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author night
 * @since 2022-10-16
 */
public interface IStoreService extends IService<Store> {

    /**
     * 获取满足条件的商户管理员信息
     * @param storeAdminQuery 查询条件
     * @return 商户管理员分页对象
     */
    PageVO<StoreAdminVO> getStoreAdminByPageAndCondition(StoreAdminQuery storeAdminQuery);

    /**
     * 获取所有商户类型
     * @return 商户类型 字符串集合
     */
    List<String> getAllTypes();

    /**
     * 限制指定ID物业登录
     */
    void modifyState(String id);

    /**
     * 获取指定ID物业的隶属小区
     * @return 小区VO分页对象
     */
    PageVO<CommunitiesVO> getSubordinations(CommunityQuery communityQuery);

    /**
     * 查询商户
     * @param storeQuery 查询条件
     * @return 商户分页对象
     */
    PageVO<StoreVO> getStores(StoreQuery storeQuery);
}
