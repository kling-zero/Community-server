package com.zeroone.star.scsetting.service;

import com.zeroone.star.project.dto.rolePrivilege.RoleDTO;
import com.zeroone.star.project.dto.setting.MenuRoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleVO;
import io.swagger.models.auth.In;

import java.util.List;

public interface UserPrivilegeService {

    public List<RoleVO> listAll(Integer id);

    public void addRole(RoleDTO roleDTO) throws Exception;

    public void updateRole(RoleDTO roleDTO);

    public void deleteRole(RoleDTO roleDTO);

    public void insertMenu(MenuRoleDTO menuRoleDTO);

    public void deleteMenu(MenuRoleDTO menuRoleDTO);
}
