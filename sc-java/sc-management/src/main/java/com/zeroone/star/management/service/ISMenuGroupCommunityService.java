package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.management.PropertyDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rito
 * @since 2022-10-17
 */
public interface ISMenuGroupCommunityService extends IService<MMenuGroupCommunity> {

    public boolean updateMenu(PropertyDTO propertyDTO) ;

    /**
     * 获取小区已选功能
     * @param communityId 小区id
     * @return
     */
    public List<MMenuGroupCommunity> getListMenuById(String communityId);

}
