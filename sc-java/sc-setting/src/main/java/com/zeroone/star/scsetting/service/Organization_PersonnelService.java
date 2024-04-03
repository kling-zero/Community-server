package com.zeroone.star.scsetting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.dto.setting.PersonnelDto;
import com.zeroone.star.scsetting.entity.Organization_Personnel;

import java.util.List;

public interface Organization_PersonnelService extends IService<Organization_Personnel> {
    List<String> selectOrgIds(String staffId);

    List<String> selectStaffIds(String orgId);
    List<String> selectStaffIds(List<String> orgIds);

    Integer associateEmployees(PersonnelDto personnelDto, OrganizationDto organizationDto);


}
