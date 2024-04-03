package com.zeroone.star.sccommonmenu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommonmenu.entity.RoleMenu;
import com.zeroone.star.sccommonmenu.mapper.RoleMenuMapper;
import com.zeroone.star.sccommonmenu.mapper.UserRoleMapper;
import com.zeroone.star.sccommonmenu.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 角色菜单关系表 服务实现类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 获得自己权限下的菜单Ids
     * @param userId
     * @return
     */
    public List<Integer> getMenuByRole(String userId){
        //获得 权限Id
        List<String> roleIds = userRoleMapper.getRoleByuserId(userId);
        //List<RoleMenu> roleMenus = this.listByIds(roleIds);

        //条件构造
        LambdaQueryWrapper<RoleMenu> roleMenuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //1.in(roid1,roid2....)
        roleMenuLambdaQueryWrapper.in(RoleMenu::getRoleId,roleIds);

        //获得 角色-菜单
        List<RoleMenu> roleMenus = this.list(roleMenuLambdaQueryWrapper);

        LinkedList<Integer> menuIds = new LinkedList<>();
        roleMenus.stream().forEach(i -> {
            menuIds.add(i.getMenuId());
        });
        return menuIds;
    }
}
