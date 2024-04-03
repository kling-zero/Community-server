package com.zeroone.star.scmenu.mapper;

import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.scmenu.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色菜单关系表 Mapper 接口
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    Integer deleteRoleMenu(@Param("roleMenu") RoleMenu roleMenu);

    Integer selectRoleIdByRoleName(@Param("roleName") String roleName);

    int updateRoleIdByMenuId(@Param("thirdMenuDTO") ThirdMenuDTO thirdMenuDTO, @Param("roleId") Integer roleId);

    int deleteRoleAndMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    RoleMenu getOneByMenuGroupId(@Param("menuGroupId") String menuGroupId);

    boolean updateStatus(@Param("menu_id") Integer menu_id, @Param("role_id") Integer role_id);
}
