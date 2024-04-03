package com.zeroone.star.scmenu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.dto.menu.MenugroupDTO;
import com.zeroone.star.project.dto.menu.SecondaryMenuDTO;
import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.query.menu.MenugroupQuery;
import com.zeroone.star.project.query.menu.SecondaryMenuQuery;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.MenugroupVO;
import com.zeroone.star.project.vo.menu.SecondaryMenuVO;
import com.zeroone.star.project.vo.menu.ThirdMenuVO;
import com.zeroone.star.scmenu.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
public interface IMenuService extends IService<Menu> {
    PageVO<ThirdMenuVO> pageThirdMenuByParentMenuId(int parentMenuId, Page<ThirdMenuDTO> page);

    ThirdMenuDTO getThirdMenu(Integer id,Integer roleId);

    Page<FirstMenuDTO> listFirstMenu(FirstMenuPageQuery firstMenuPageQuery);

    FirstMenuDTO getFirstMenu(Integer id, Integer roleId);

    PageVO<ThirdMenuVO> listThirdMenu(ThirdMenuPageQuery thirdMenuPageQuery);

    ThirdMenuDTO getAThirdMenu(Integer id, Integer parentMenuId);

    int saveAThirdMenu(ThirdMenuDTO thirdMenuDTO);

    int updateThirdMenu(ThirdMenuDTO thirdMenuDTO);

    Integer removeThirdMenuById(Integer menuId);

    Integer getRoleIdByRoleName(String roleName);


    PageVO<MenugroupVO> listAll(MenugroupQuery query);

    boolean saveMenuGroup(MenugroupDTO menugroupDTO);

    //    MenugroupVO updateMenuGroup(MenugroupDTO menugroupDTO);
    MenugroupVO updateMenuGroup(MenugroupDTO menugroupDTO,String menuGroupId);

    Boolean removeMenugroup(Integer Id);

    List<SecondaryMenuVO> selectSubmenu(SecondaryMenuQuery query);
    boolean saveSubmenu(SecondaryMenuDTO secondaryMenuDTO);

    SecondaryMenuVO updateSubmenu(SecondaryMenuDTO secondaryMenuDTO, Integer secondaryMenuId);

    boolean deleteSubmenu(Integer Id,  String roleName);
}
