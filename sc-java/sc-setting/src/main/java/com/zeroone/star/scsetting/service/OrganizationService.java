package com.zeroone.star.scsetting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.vo.setting.OrganizationTreeVO;
import com.zeroone.star.scsetting.entity.Organization;

import java.util.List;

public interface OrganizationService extends IService<Organization> {

    List<OrganizationTreeVO> selectOrganizations(List<String> orgIds);

    Integer insertOrganization(OrganizationDto dto);

    Integer updateOrganization(OrganizationDto dto);

    Integer deleteOrganization(String organizationId);

    OrganizationDto selectOrganizationById(String organizationId);
}
