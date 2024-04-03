package com.zeroone.star.project.rolePrivilege.roleFunction;

import com.zeroone.star.project.dto.rolePrivilege.roleFunction.RoleAssFunctionDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleFunctionQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleNotFunctionVO;

/**
 *
 */
public interface UserAssFunctionApis {

    /**
     * 查询该权限组没有的权限
     * @param roleFunctionQuery 查询对象
     * @return  权限集合
     */
    JsonVO<RoleNotFunctionVO> roleNotFunction(RoleFunctionQuery roleFunctionQuery);

    /**
     * 角色和功能关联
     * @param roleAssFunctionDTO 角色、功能关联数据
     * @return
     */
    JsonVO<Object> roleAssociatedFunction(RoleAssFunctionDTO roleAssFunctionDTO);


    /**
     * 角色和功能取消关联
     * @param roleAssFunctionDTO 角色、功能取消关联数据
     * @return
     */
    JsonVO<Object> deleteRoleAssFunction(RoleAssFunctionDTO roleAssFunctionDTO);
}
