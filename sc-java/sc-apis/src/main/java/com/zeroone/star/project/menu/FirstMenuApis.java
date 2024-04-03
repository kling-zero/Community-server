package com.zeroone.star.project.menu;

import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.FirstMenuVO;

public interface FirstMenuApis {
    /**
     * 分页查询所有一级菜单
     * @param firstMenuPageQuery 一级菜单分页查询对象
     * @return 一级菜单分页展示对象
     */
    JsonVO<PageVO<FirstMenuVO>> listFirstMenu(FirstMenuPageQuery firstMenuPageQuery);

    /**
     * 添加一级菜单
     * @param firstMenuDTO 一级菜单数据传输对象
     * @return 操作信息message
     */
    JsonVO<String> addFirstMenu(FirstMenuDTO firstMenuDTO);

    /**
     * 修改一级菜单
     * @param firstMenuDTO 一级菜单数据传输对象
     * @return 操作信息message
     */
    JsonVO<String> updateFirstMenu(FirstMenuDTO firstMenuDTO);

    /**
     * 根据菜单组id和商户类型删除一级菜单
     * @param id 一级菜单的id
     * @return 操作信息message
     */
    JsonVO<String> removeFirstMenu(Integer id, String roleName);
}
