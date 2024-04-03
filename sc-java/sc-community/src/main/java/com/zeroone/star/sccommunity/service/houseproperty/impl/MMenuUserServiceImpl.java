package com.zeroone.star.sccommunity.service.houseproperty.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.sccommunity.entity.houseproperty.MMenuUser;
import com.zeroone.star.sccommunity.mapper.houseproperty.MMenuUserMapper;
import com.zeroone.star.sccommunity.service.houseproperty.IMMenuUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suqier
 * @since 2022-10-22
 */
@Service
public class MMenuUserServiceImpl extends ServiceImpl<MMenuUserMapper, MMenuUser> implements IMMenuUserService {

    @Autowired
    MMenuUserMapper mMenuUserMapper;

    @Override
    public PageVO<UserMenuVO> queryListMenuUser(UserMenuQuery query) {
        Page<MMenuUser> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<MMenuUser> wrapper = new QueryWrapper<>();
        Page<MMenuUser> mMenuUser = mMenuUserMapper.selectPage(page,wrapper);
        return PageVO.create(mMenuUser,UserMenuVO.class);
    }
}
