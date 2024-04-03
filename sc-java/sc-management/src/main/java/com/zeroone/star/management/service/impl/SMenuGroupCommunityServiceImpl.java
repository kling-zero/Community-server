package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.zeroone.star.management.mapper.SMenuGroupCommunityMapper;
import com.zeroone.star.management.service.IMMenuGroupCommunityService;
import com.zeroone.star.management.service.IMMenuGroupService;
import com.zeroone.star.management.service.ISMenuGroupCommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.management.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zeroone.star.management.service.impl.SStoreServiceImpl.getDateRandomCode;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rito
 * @since 2022-10-17
 */
@Service
public class SMenuGroupCommunityServiceImpl extends ServiceImpl<SMenuGroupCommunityMapper, MMenuGroupCommunity> implements ISMenuGroupCommunityService {

    @Autowired
    SMenuGroupCommunityMapper sMenuGroupCommunityMapper ;
    @Autowired
    IMMenuGroupService imMenuGroupService;
    @Autowired
    IMMenuGroupCommunityService imMenuGroupCommunityService;
    /**
     * 更新小区功能菜单
     * @param propertyDTO
     * @return
     */
    @Override
    public boolean updateMenu(PropertyDTO propertyDTO) {
        LocalDateTime now = LocalDateTime.now();
        //构建更新对象
        LambdaUpdateWrapper<MMenuGroupCommunity> updateWrapper = new LambdaUpdateWrapper<>();
        //根据id查询该小区的功能菜单
        String communityId = propertyDTO.getCommunityIds().get(0);
        List<String> groupIds = propertyDTO.getGroupIds();
        //查询所有status为0的字段，置为1
        updateWrapper.eq(MMenuGroupCommunity::getCommunityId,communityId)
                    .eq(MMenuGroupCommunity::getStatusCd,0)
                    .set(MMenuGroupCommunity::getStatusCd,1);
        sMenuGroupCommunityMapper.update(null, updateWrapper);

        //获取g_id对应的功能名
        Map<String,String> map = new HashMap();
        List<MMenuGroup> list = imMenuGroupService.list();
        for (MMenuGroup mMenuGroup : list) { //获取菜单gid跟name
            map.put(mMenuGroup.getGId(),mMenuGroup.getName());
        }

        //将新的功能菜单加入m_menu_group_community
        MMenuGroupCommunity mMenuGroupCommunity = new MMenuGroupCommunity();
        mMenuGroupCommunity.setCommunityId(communityId);
        mMenuGroupCommunity.setCommunityName(propertyDTO.getCommunityName());
        mMenuGroupCommunity.setCreateTime(now);
        for (String groupId:groupIds){  //遍历传入的groupids来添加到mMenuGroupCommunity数据
            mMenuGroupCommunity.setGcId("10"+getDateRandomCode());
            mMenuGroupCommunity.setGId(groupId);
            mMenuGroupCommunity.setName(map.get(groupId));
            imMenuGroupCommunityService.save(mMenuGroupCommunity);
        }
        return true;
    }


    /**
     * 查询所选小区功能菜单
     * @param id
     * @return
     */
    @Override
    public List<MMenuGroupCommunity> getListMenuById(String id) {
        LambdaQueryWrapper<MMenuGroupCommunity> queryWrapper = new LambdaQueryWrapper();
        //查询对应小区id能使用的功能
        queryWrapper.eq(MMenuGroupCommunity::getCommunityId,id)
                .eq(MMenuGroupCommunity::getStatusCd,0);
        List<MMenuGroupCommunity> menus = sMenuGroupCommunityMapper.selectList(queryWrapper);
        return menus;
    }
}
