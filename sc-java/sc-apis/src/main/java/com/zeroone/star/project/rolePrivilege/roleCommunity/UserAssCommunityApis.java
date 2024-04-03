package com.zeroone.star.project.rolePrivilege.roleCommunity;

import com.zeroone.star.project.dto.rolePrivilege.roleCommunity.RoleAssCommunityDTO;
import com.zeroone.star.project.dto.rolePrivilege.roleCommunity.RoleNotAssCommunityDTO;
import com.zeroone.star.project.query.rolePrivilege.RoleCommunityQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.role.RoleCommunityVO;
import com.zeroone.star.project.vo.role.RoleNotCommunityVO;

/**
 * 角色关联小区相关操作的接口
 */
public interface UserAssCommunityApis {
    /**
     * 角色和小区关联
     * @param roleAssCommunityDTO 角色、小区关联数据
     * @return
     */
    JsonVO<Object> roleAssociatedCommunity(RoleAssCommunityDTO roleAssCommunityDTO);

    /**
     * 角色和小区取消关联
     * @param roleNotAssCommunityDTO 角色、小区关联数据
     * @return
     */
    JsonVO<Object> deleteRoleAssCommunity(RoleNotAssCommunityDTO roleNotAssCommunityDTO);

    /**
     * 根据 roleID 查询该角色关联的所有小区
     * @param roleCommunityQuery 查询数据
     * @return
     */
    JsonVO<RoleCommunityVO> listRoleCommunity(RoleCommunityQuery roleCommunityQuery);

    /**
     *  根据 roleID 查询不与该角色关联的所有小区
     * @param roleCommunityQuery
     * @return
     */
    JsonVO<RoleNotCommunityVO> listRoleNotCommunity(RoleCommunityQuery roleCommunityQuery);

}



