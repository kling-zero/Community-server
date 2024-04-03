package com.zeroone.star.scsetting.service.impl;

import com.zeroone.star.project.dto.rolePrivilege.RoleDTO;
import com.zeroone.star.project.dto.setting.MenuRoleDTO;
import com.zeroone.star.project.vo.role.RoleVO;
import com.zeroone.star.scsetting.entity.Role;
import com.zeroone.star.scsetting.mapper.UserPrivilegeMapper;
import com.zeroone.star.scsetting.service.UserPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPrivilegeServiceImpl implements UserPrivilegeService {

    @Resource
    UserPrivilegeMapper userPrivilegeMapper;

    @Override
    public List<RoleVO> listAll(Integer id) {
        List<Role> roles = userPrivilegeMapper.listAll(id);
        ArrayList<RoleVO> roleVOs = new ArrayList<>();
        for (Role role: roles
             ) {
            RoleVO vo = new RoleVO();
            vo.setRoleId(role.getId().toString());
            vo.setUsername(role.getName());
            roleVOs.add(vo);
        }
        return roleVOs;
    }

    @Override
    public void addRole(RoleDTO roleDTO) throws Exception {
        int row = userPrivilegeMapper.addRole(roleDTO);
        if (row == 0){
            throw new Exception("不可添加重复角色");
        }
    }

    @Override
    public void updateRole(RoleDTO roleDTO) {
        userPrivilegeMapper.updateRole(roleDTO);
    }

    @Override
    public void deleteRole(RoleDTO roleDTO) {
        userPrivilegeMapper.deleteRole(roleDTO);
    }

    @Override
    public void insertMenu(MenuRoleDTO menuRoleDTO) {
        userPrivilegeMapper.insertMenu(menuRoleDTO);
    }

    @Override
    public void deleteMenu(MenuRoleDTO menuRoleDTO) {
        userPrivilegeMapper.deleteMenu(menuRoleDTO);
    }
}
