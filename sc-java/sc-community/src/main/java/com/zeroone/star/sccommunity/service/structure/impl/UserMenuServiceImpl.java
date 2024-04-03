package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.entity.structure.UserMenu;
import com.zeroone.star.sccommunity.mapper.structure.UserMenuMapper;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import com.zeroone.star.sccommunity.service.structure.IUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 根据条件（communityId）查询用户菜单；就是在这小区的所有用户信息；
 */
@Service
public class UserMenuServiceImpl extends ServiceImpl<UserMenuMapper, UserMenu> implements IUserMenuService {

    @Autowired
    UserMenuMapper userMenuMapper;
    @Autowired
    ITDictService itDictService;

    /**
     * 根据communityId查询用户菜单；
     *
     * @param query
     * @return
     */
    @Override
    public PageVO<UserMenuVO> listAllUserMenu(UserMenuQuery query) {
        Page<UserMenu> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<UserMenu> wrapper = new QueryWrapper<>();
        Page<UserMenu> pages = userMenuMapper.selectPage(page, wrapper);
        //对数据状态码进行转换
        for (UserMenu userMenu : pages.getRecords()) {
            TDict tDict = itDictService.selectByStatus(userMenu.getStatusCd(), "all", "status_cd");
            if (tDict != null) {
                userMenu.setStatusCd(tDict.getName());
            }
        }
        return PageVO.create(pages, UserMenuVO.class);
    }
}
