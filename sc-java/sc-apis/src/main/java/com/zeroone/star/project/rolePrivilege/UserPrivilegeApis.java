package com.zeroone.star.project.rolePrivilege;

import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleAssStaffDTO;
import com.zeroone.star.project.dto.rolePrivilege.RoleDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleNotAssStaffDTO;
import com.zeroone.star.project.dto.setting.MenuRoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleVO;

import java.util.List;

/**
 *
 */
public interface UserPrivilegeApis {
    /**
     *
     * @return 所有角色列表
     */
    JsonVO<List<RoleVO>> listAllRoles();
    /**
     * @param roleDTO 前端传递的待添加的角色信息
     * @return 返回角色添加成功的信息
     */
    JsonVO<String> addRole(RoleDTO roleDTO);

    /**
     * @param roleDTO 前端传递的待修改的角色信息
     * @return 返回角色修改成功的信息
     */
    JsonVO<String> updateRole(RoleDTO roleDTO);

    /**
     * @param roleDTO 前端传递待删除的roleId
     * @return 返回角色删除成功的信息
     */
    JsonVO<String> deleteRole(RoleDTO roleDTO);

    /**
     * @param menuRoleDTO 前端传递待插入的角色菜单
     *
     * @return 返回成功的信息
     */
    JsonVO<String> insertMenu(MenuRoleDTO menuRoleDTO);

    /**
     * @param menuRoleDTO 前端传递待删除的角色菜单
     *
     * @return 返回成功的信息
     */
    JsonVO<String> deleteMenu(MenuRoleDTO menuRoleDTO);

}



