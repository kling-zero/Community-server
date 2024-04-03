package com.zeroone.star.scmenu.service;

import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.scmenu.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色菜单关系表 服务类
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    Boolean removeRoleMenu(RoleMenu roleMenu);

    int saveARoleMenu(ThirdMenuDTO thirdMenuDTO, Integer menuId);

    int updateRoleMenu(ThirdMenuDTO thirdMenuDTO);

    Integer removeRoleAndMenu(Integer roleId, Integer menuId);
    RoleMenu getOneByMenuGroupId(@Param("MenuGroupId") String menuGroupId);
}
