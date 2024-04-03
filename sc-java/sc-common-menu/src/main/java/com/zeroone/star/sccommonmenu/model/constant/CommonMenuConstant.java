package com.zeroone.star.sccommonmenu.model.constant;

import com.zeroone.star.project.vo.commonMenu.MMenuUserVO;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;

/**
 * @Author j1-tao
 * 常用菜单常量
 */
public class CommonMenuConstant {

    //redis键
    public static final String  MENU_USER_KEY = "MENUUSER:USERID";
    public static final String  MENU_KEY = "MENU:USERID";

    //返回类型
    public static final MMenuUserVO M_MENU_USER_VO = new MMenuUserVO();

    public static final TreeMenuVO TREE_MENU_VO = new TreeMenuVO();
}
