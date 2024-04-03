package com.zeroone.star.sccommunity.service.houseproperty;

import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.sccommunity.entity.houseproperty.MMenuUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suqier
 * @since 2022-10-22
 */
public interface IMMenuUserService extends IService<MMenuUser> {

    /**
     * 分页条件查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageVO<UserMenuVO> queryListMenuUser(UserMenuQuery query);

}
