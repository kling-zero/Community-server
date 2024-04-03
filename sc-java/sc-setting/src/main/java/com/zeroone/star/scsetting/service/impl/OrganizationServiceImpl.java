package com.zeroone.star.scsetting.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.vo.setting.OrganizationTreeVO;
import com.zeroone.star.scsetting.entity.Organization;
import com.zeroone.star.scsetting.mapper.OrganizationMapper;
import com.zeroone.star.scsetting.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {
    @Override
    public List<OrganizationTreeVO> selectOrganizations(List<String> orgIds) {
        List<OrganizationTreeVO> organizationTreeVOList = new ArrayList<>();
        orgIds.forEach(orgId -> {
            LambdaQueryWrapper<Organization> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Organization::getOrgId, orgId);
            Organization organization = baseMapper.selectOne(queryWrapper);
            OrganizationTreeVO organizationTreeVO = new OrganizationTreeVO();
            BeanUtils.copyProperties(organization, organizationTreeVO);
            organizationTreeVOList.add(organizationTreeVO);
        });
        return organizationTreeVOList;
    }

    @Override
    public Integer insertOrganization(OrganizationDto dto) {
        Organization organization = BeanUtil.copyProperties(dto, Organization.class);
        organization.setCreateTime(LocalDateTime.now());
        int insert = baseMapper.insert(organization);
        return insert;
    }

    @Override
    public Integer updateOrganization(OrganizationDto dto) {
        Organization organization = BeanUtil.copyProperties(dto, Organization.class);
        int update = baseMapper.updateById(organization);
        return update;
    }

    @Override
    public Integer deleteOrganization(String organizationId) {
        int delete = baseMapper.deleteById(organizationId);
        return delete;
    }

    @Override
    public OrganizationDto selectOrganizationById(String organizationId) {
        Organization organization = baseMapper.selectById(organizationId);
        OrganizationDto organizationDto = new OrganizationDto();
        BeanUtils.copyProperties(organization, organizationDto);
        return organizationDto;
    }
}
