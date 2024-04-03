package com.zeroone.star.sccommonmenu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sccommonmenu.entity.RoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 服务类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
public interface IRoleMenuService extends IService<RoleMenu> {
     List<Integer> getMenuByRole(String userId);
}
