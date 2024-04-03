package com.zeroone.star.project.menu;

import com.zeroone.star.project.dto.menu.MenugroupDTO;
import com.zeroone.star.project.query.menu.MenugroupQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.MenugroupVO;

import java.util.List;

/**
 * 姓名:李惟
 * 内容:
 * 注释:
 */
public interface MenugroupApis {
    //根据条件查询菜单组信息
    JsonVO<PageVO<MenugroupVO>> quarryAll(MenugroupQuery condition);

    //修改信息
//    JsonVO<MenugroupVO> updateMenugroup(MenugroupDTO menugroupDTO);
    JsonVO<MenugroupVO> updateMenugroup(MenugroupDTO menugroupDTO, String menuGroupId) throws Exception;
    //删除信息
    JsonVO<String> deleteMenugroup(Integer Id);

    //添加信息
    JsonVO<String> saveMenugroup(MenugroupDTO menugroupDTO);




}
