package com.zeroone.star.sccommunity.service.houseproperty.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.OwnersQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.OwnersVO;
import com.zeroone.star.sccommunity.entity.houseproperty.BusinessCommunity;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingOwner;
import com.zeroone.star.sccommunity.entity.houseproperty.BuildingOwnerAttr;
import com.zeroone.star.sccommunity.entity.houseproperty.Owners;
import com.zeroone.star.sccommunity.mapper.houseproperty.BuildingOwnerAttrMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBuildingOwnerMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.HouseBusinessCommunityMapper;
import com.zeroone.star.sccommunity.mapper.houseproperty.OwnerMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IOwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/23
 */
@Service
public class OwnersServiceImp extends ServiceImpl<OwnerMapper, Owners> implements IOwnersService {
    @Autowired
    HouseBuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    HouseBusinessCommunityMapper businessCommunityMapper;
    @Autowired
    BuildingOwnerAttrMapper buildingOwnerAttrMapper;
    @Override
    public PageVO<OwnersVO> queryAllOwners(OwnersQuery query) {
        System.out.println(query.toString());
        Page<Owners> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<Owners> wrapper = new QueryWrapper<>();
        Page<Owners> pages = baseMapper.selectPage(page,wrapper);
        for (Owners owner: pages.getRecords()) {
            QueryWrapper<BuildingOwner> buildingOwnerQueryWrapper = new QueryWrapper<>();
            buildingOwnerQueryWrapper.eq("member_id",query.getMemberId())
                    .eq("owner_id",query.getOwnerId());
            BuildingOwner buildingOwner = buildingOwnerMapper.selectOne(buildingOwnerQueryWrapper);
            owner.setOwnerId(query.getOwnerId());
            owner.setOwnerTypeCd(buildingOwner.getOwnerTypeCd());
            owner.setAge(buildingOwner.getAge());
            owner.setMemberId(query.getMemberId());
            owner.setCreateTime(buildingOwner.getCreateTime());
            owner.setIdCard(buildingOwner.getIdCard());
            owner.setRemark(buildingOwner.getRemark());
            owner.setLink(buildingOwner.getLink());
            owner.setSex(buildingOwner.getSex());
            owner.setUserName(buildingOwner.getName());
            QueryWrapper<BusinessCommunity> businessCommunityQueryWrapper = new QueryWrapper<>();
            businessCommunityQueryWrapper.eq("community_id",buildingOwner.getCommunityId());
            BusinessCommunity businessCommunity = businessCommunityMapper.selectOne(businessCommunityQueryWrapper);
            owner.setName(businessCommunity.getName());
            QueryWrapper<BuildingOwnerAttr> ownerAttrDtosQueryWrapper = new QueryWrapper<>();
            ownerAttrDtosQueryWrapper.eq("member_id",owner.getMemberId());
            List<BuildingOwnerAttr> ownerAttrDtosList = buildingOwnerAttrMapper.selectList(ownerAttrDtosQueryWrapper);
            owner.setOwnerAttrDtos(ownerAttrDtosList);
            if(buildingOwner.getOwnerTypeCd().equals("1001")){
                owner.setOwnerTypeName("业主本人");
            }else if(buildingOwner.getOwnerTypeCd().equals("1002")) {
                owner.setOwnerTypeName("家庭成员");
            }
        }
        return PageVO.create(pages,OwnersVO.class);
    }
}
