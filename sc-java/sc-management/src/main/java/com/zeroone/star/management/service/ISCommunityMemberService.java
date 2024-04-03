package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.SCommunity;
import com.zeroone.star.management.entity.SCommunityMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.management.CommunityQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nmh、rito
 * @since 2022-10-17
 */
public interface ISCommunityMemberService extends IService<SCommunityMember> {
    /**
     * 添加小区物业创建信息
     * @param communityByName 小区信息
     * @param memberID  物业ID
     * @return
     */
    public int insertISCommunityMemberService(SCommunity communityByName,String memberID);

    public boolean removeCommunity(CommunityQuery communityQuery);
}
