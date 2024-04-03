package com.zeroone.star.scsetting.mapper;


import com.zeroone.star.project.dto.rolePrivilege.RoleDTO;
import com.zeroone.star.project.dto.setting.MenuRoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleVO;
import com.zeroone.star.scsetting.entity.Role;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPrivilegeMapper {
    public int addRole(RoleDTO roleDTO);

    public void updateRole(RoleDTO roleDTO);

    public void deleteRole(RoleDTO roleDTO);

    public List<Role> listAll(@Param("userId") Integer id);

    public void insertMenu(MenuRoleDTO menuRoleDTO);

    public void deleteMenu(MenuRoleDTO menuRoleDTO);
}
