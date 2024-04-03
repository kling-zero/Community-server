package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.management.entity.SCommunity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nmh
 * @since 2022-10-16
 */
public interface IMMenuGroupCommunityService extends IService<MMenuGroupCommunity> {

    /**
     * 添加小区物业功能信息
     * @param comName 小区id
     * @param id  功能id
     * @param sCommunity 小区信息
     * @param menuGroup 功能信息
     * @return
     */
    public int insertMMenuGroupCommunity(String comName,String id,SCommunity sCommunity, MMenuGroup menuGroup);


}
