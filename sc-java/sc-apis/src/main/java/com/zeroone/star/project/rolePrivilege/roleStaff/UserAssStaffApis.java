package com.zeroone.star.project.rolePrivilege.roleStaff;

import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleAssStaffDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleStaff.RoleNotAssStaffDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleStaffQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.StaffVO;

import java.util.List;

/**
 * 角色关联员工相关操作的接口
 */
public interface UserAssStaffApis {
    /**
     * 角色和员工关联
     *
     * @param roleAssStaffDTO 角色、员工关联数据
     * @return
     */
    JsonVO<Object> roleAssociatedStaff(RoleAssStaffDTO roleAssStaffDTO);

    /**
     * 角色和员工取消关联
     *
     * @param roleNotAssStaffDTO 角色、员工关联数据
     * @return
     */
    JsonVO<Object> deleteRoleAssStaff(RoleNotAssStaffDTO roleNotAssStaffDTO);

    /**
     * 根据 roleID 查询该角色关联的所有员工
     *
     * @param roleStaffQuery 查询数据
     * @return
     */
    JsonVO<List<StaffVO>> listRoleStaff(RoleStaffQuery roleStaffQuery);

    /**
     * 根据 roleID 查询不与该角色关联的所有员工
     * @param roleStaffQuery  查询数据
     * @return
     */
    JsonVO<List<StaffVO>> listStaffNoRole(RoleStaffQuery roleStaffQuery);

}



