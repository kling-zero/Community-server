package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.sccommunity.entity.structure.UserMenu;

public interface IUserMenuService extends IService<UserMenu> {

    PageVO<UserMenuVO> listAllUserMenu(UserMenuQuery query);
}
