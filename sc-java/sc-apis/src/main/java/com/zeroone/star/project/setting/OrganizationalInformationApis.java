package com.zeroone.star.project.setting;

import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.query.setting.PersonnelQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.OrganizationTreeVO;
import com.zeroone.star.project.vo.setting.PersonnelVO;
import com.zeroone.star.project.vo.setting.TreeNodeVO;

import java.util.List;

public interface OrganizationalInformationApis {

    JsonVO<List<TreeNodeVO<OrganizationTreeVO>>> getOrganizations() throws Exception;
    JsonVO<PageVO<PersonnelVO>> queryPersonnelByName(String organizationId, PersonnelQuery personnelQuery);
    JsonVO<List<PersonnelVO>> queryNotAssociatedPersonnelByName(String organizationId,String name) throws Exception;

    JsonVO<Integer> insertOrganization(OrganizationDto dto);

    JsonVO<Integer> updateOrganization(OrganizationDto dto);

    JsonVO<Integer> deleteOrganization(String organizationId);

    JsonVO<Integer> associateEmployees(String organizationId,String personnelId);

}
