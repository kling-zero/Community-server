package com.zeroone.star.scsetting.controller;

import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.dto.setting.OrganizationDto;
import com.zeroone.star.project.dto.setting.PersonnelDto;
import com.zeroone.star.project.query.setting.PersonnelQuery;
import com.zeroone.star.project.setting.OrganizationalInformationApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.OrganizationTreeVO;
import com.zeroone.star.project.vo.setting.PersonnelVO;
import com.zeroone.star.project.vo.setting.TreeNodeVO;
import com.zeroone.star.scsetting.service.OrganizationService;
import com.zeroone.star.scsetting.service.Organization_PersonnelService;
import com.zeroone.star.scsetting.service.PersonnelService;
import com.zeroone.star.scsetting.util.NodeMapper;
import com.zeroone.star.scsetting.util.TreeNode;
import com.zeroone.star.scsetting.util.TreeUtils;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author insist
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/OrganizationalInformation")
@Api(tags = "组织信息")
@Validated
public class OrganizationalInformationController implements OrganizationalInformationApis {
    @Resource
    PersonnelService personnelService;

    @Resource
    OrganizationService organizationService;

    @Resource
    NodeMapper<OrganizationTreeVO> nodeMapper;
    @Resource
    UserHolder userHolder;

    @Resource
    Organization_PersonnelService organization_personnelService;

    @Override
    @GetMapping("getOrganizations")
    @ApiOperation(value = "查询组织树")
    public JsonVO<List<TreeNodeVO<OrganizationTreeVO>>> getOrganizations() throws Exception {
        UserDTO currentUser = userHolder.getCurrentUser();
        String id = currentUser.getId() + "";
//        String id = "888";
        List<String> orgIds = organization_personnelService.selectOrgIds(id);
        List<OrganizationTreeVO> organizationTreeVOList = organizationService.selectOrganizations(orgIds);
        List<TreeNode<OrganizationTreeVO>> treeNodeList = TreeUtils.listToTree(organizationTreeVOList, nodeMapper);
        List<TreeNodeVO<OrganizationTreeVO>> tree = new ArrayList<>();
        for (TreeNode<OrganizationTreeVO> sub : treeNodeList) {
            TreeNodeVO<OrganizationTreeVO> one = new TreeNodeVO<>();
            BeanUtil.copyProperties(sub, one);
            tree.add(one);
        }
        return JsonVO.success(tree);
    }

    @Override
    @GetMapping("queryPersonnelByName")
    @ApiOperation(value = "根据姓名查询员工")
    public JsonVO<PageVO<PersonnelVO>> queryPersonnelByName(String organizationId, PersonnelQuery personnelQuery) {
        List<String> staffIds = organization_personnelService.selectStaffIds(organizationId);
        PageVO<PersonnelVO> personnelPageVO = personnelService.queryPersonnelByName(staffIds, personnelQuery);
        return JsonVO.success(personnelPageVO);
    }

    @Override
    @GetMapping("queryNotAssociatedPersonnelByName")
    @ApiOperation(value = "根据姓名查询未关联员工")
    public JsonVO<List<PersonnelVO>> queryNotAssociatedPersonnelByName(String organizationId, String name) throws Exception {
        UserDTO currentUser = userHolder.getCurrentUser();
        String id = currentUser.getId() + "";
//        String id = "21";
        List<String> orgIds = organization_personnelService.selectOrgIds(id);
        orgIds.remove(organizationId);
        List<String> staffIds = organization_personnelService.selectStaffIds(orgIds);
        List<PersonnelVO> personnelVOS = personnelService.queryNotAssociatedPersonnelByName(staffIds, name);
        return JsonVO.success(personnelVOS);
    }

    @Override
    @PostMapping("insertOrganization")
    @ApiOperation(value = "插入组织")
    public JsonVO<Integer> insertOrganization(OrganizationDto dto) {
        Integer integer = organizationService.insertOrganization(dto);
        return JsonVO.success(integer);
    }

    @Override
    @PutMapping("updateOrganization")
    @ApiOperation(value = "修改组织")
    public JsonVO<Integer> updateOrganization(OrganizationDto dto) {
        Integer integer = organizationService.updateOrganization(dto);
        return JsonVO.success(integer);
    }

    @Override
    @DeleteMapping("deleteOrganization")
    @ApiOperation(value = "删除组织")
    public JsonVO<Integer> deleteOrganization(String organizationId) {
        Integer integer = organizationService.deleteOrganization(organizationId);
        return JsonVO.success(integer);
    }

    @Override
    @PostMapping("associateEmployees")
    @ApiOperation(value = "关联员工")
    public JsonVO<Integer> associateEmployees(String organizationId, String personnelId) {
        PersonnelDto personnelDto = personnelService.selectPersonnelById(personnelId);
        OrganizationDto organizationDto = organizationService.selectOrganizationById(organizationId);
        Integer integer = organization_personnelService.associateEmployees(personnelDto, organizationDto);
        return JsonVO.success(integer);
    }
}

