package com.zeroone.star.scsetting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.dto.setting.PersonnelDto;
import com.zeroone.star.scsetting.entity.Organization_Personnel;
import com.zeroone.star.scsetting.mapper.Organization_PersonnelMapper;
import com.zeroone.star.scsetting.service.Organization_PersonnelService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Organization_PersonnelServiceImpl extends ServiceImpl<Organization_PersonnelMapper, Organization_Personnel> implements Organization_PersonnelService {
    @Override
    public List<String> selectOrgIds(String staffId) {
        LambdaQueryWrapper<Organization_Personnel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Organization_Personnel::getStaffId, staffId);
        List<Organization_Personnel> organization_personnels = baseMapper.selectList(queryWrapper);
        List<String> collect = organization_personnels.stream().map((item) -> {
            return item.getOrgId();
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<String> selectStaffIds(String orgId) {
        LambdaQueryWrapper<Organization_Personnel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Organization_Personnel::getOrgId, orgId);
        List<Organization_Personnel> organization_personnels = baseMapper.selectList(queryWrapper);
        List<String> collect = organization_personnels.stream().map((item) -> {
            return item.getStaffId();
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<String> selectStaffIds(List<String> orgIds) {
        LambdaQueryWrapper<Organization_Personnel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Organization_Personnel::getOrgId, orgIds);
        List<Organization_Personnel> organization_personnels = baseMapper.selectList(queryWrapper);
        List<String> collect = organization_personnels.stream().map((item) -> {
            return item.getStaffId();
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Integer associateEmployees(PersonnelDto personnelDto, OrganizationDto organizationDto) {
        Organization_Personnel organization_personnel = new Organization_Personnel();
        organization_personnel.setOrgId(organizationDto.getOrgId());
        organization_personnel.setStaffId(personnelDto.getId() + "");
        organization_personnel.setCreateTime(LocalDateTime.now());
        organization_personnel.setRelId(personnelDto.getUserId());
        organization_personnel.setBId(organizationDto.getBId());
        organization_personnel.setStatus_cd(organizationDto.getStatusCd());
        organization_personnel.setStoreId(organizationDto.getStoreId());
        organization_personnel.setRelCd(personnelDto.getLevelCd());
        int insert = baseMapper.insert(organization_personnel);
        return insert;
    }
}
