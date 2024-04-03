package com.zeroone.star.scmenu.service.impl;

import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.scmenu.entity.RoleMenu;
import com.zeroone.star.scmenu.mapper.MenuMapper;
import com.zeroone.star.scmenu.mapper.RoleMenuMapper;
import com.zeroone.star.scmenu.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单关系表 服务实现类
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Autowired
    MenuMapper menuMapper;

    @Override
    public Boolean removeRoleMenu(RoleMenu roleMenu) {
        return roleMenuMapper.deleteRoleMenu(roleMenu) == 1;
    }

    @Override
    public int saveARoleMenu(ThirdMenuDTO thirdMenuDTO, Integer menuId) {
        RoleMenu roleMenu = new RoleMenu();

        Integer roleId = null;
        if(thirdMenuDTO.getRoleName()==null || "".equals(thirdMenuDTO.getRoleName().trim())){
            log.error("未填入管理员名称");
            return 0;
        }
        else{
            roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
            if(roleId==null){
                log.error("没有这个管理员");
                return 0;
            }
        }

        roleMenu.setRoleId(roleId);
        roleMenu.setMenuId(menuId);

        roleMenuMapper.insert(roleMenu);
        return roleMenu.getRoleId();
    }

    @Override
    public int updateRoleMenu(ThirdMenuDTO thirdMenuDTO) {
        //判断传入的管理员类型是否正确
        Integer roleId = null;
        if(thirdMenuDTO.getRoleName()==null || "".equals(thirdMenuDTO.getRoleName().trim())){
            log.error("未填入管理员名称");
            return 0;
        }
        else{
            //判断是否存在
            roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
            if(roleId==null){
                log.error("没有这个管理员");
                return 0;
            }
        }

        //再次判断是否有id(可能menu表有数据，但是role_menu没有)
        if(thirdMenuDTO.getId() == null){
            log.error("未填入id");
            return 0;
        }
        else{
            Integer existId = 0;
            existId = menuMapper.selectExistMenuById(thirdMenuDTO.getId());
            if(existId==0){
                log.error("没有这个id");
                return 0;
            }
        }

        return roleMenuMapper.updateRoleIdByMenuId(thirdMenuDTO, roleId);
    }

    @Override
    public Integer removeRoleAndMenu(Integer roleId, Integer menuId) {
        //判断menuId是否合法
        if(menuId==null){
            log.error("未填入id");
            return null;
        }

        Integer result = null;
        result = roleMenuMapper.deleteRoleAndMenu(roleId, menuId);
        if(result==0){
            log.error("没有这个菜单id 或者 管理员名称与id没有关系");
            return null;
        }

        return result;
    }

    public RoleMenu getOneByMenuGroupId(String menuGroupId){
        RoleMenu roleMenu = roleMenuMapper.getOneByMenuGroupId(menuGroupId);
        return roleMenu;
    }
}
