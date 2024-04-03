package com.zeroone.star.project.community.structure.userMenu;

import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;

/**
 * @Description 用户菜单查询api
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

public interface UserMenuApis {

    /**
     * 分页查询用户菜单
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<UserMenuVO>> queryAll(UnitsAndFloorQuery condition);
}
