package com.zeroone.star.sccommonmenu.service;

import com.zeroone.star.project.dto.commonMenu.MMenuUserDTO;
import com.zeroone.star.project.query.commonMenu.MMenuUserQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.commonMenu.MMenuUserVO;
import com.zeroone.star.sccommonmenu.entity.MMenuUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-15
 */
public interface IMMenuUserService extends IService<MMenuUser> {
    List<MMenuUserVO> listMenuUser(MMenuUserQuery mMenuUserQuery, String userId);
    Boolean deleteMenuUser(MMenuUserDTO mMenuUserDTO);

    Boolean saveMenuUser(MMenuUserDTO mMenuUserDTO);
}
