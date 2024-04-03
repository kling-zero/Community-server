package com.zeroone.star.project.menu;

import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.ThirdMenuVO;

public interface ThirdMenuApis {
    /**
     * 分页查询所有三级菜单
     * @param thirdMenuPageQuery 三级菜单分页查询对象
     * @return 三级菜单展示对象
     */
    JsonVO<PageVO<ThirdMenuVO>> queryThirdMenu(ThirdMenuPageQuery thirdMenuPageQuery);

    /**
     * 根据三级菜单id和父级菜单id查询一个三级菜单
     * @param id 三级菜单id
     * @return ThirdMenuDTO 一个三级菜单传输对象
     */
    JsonVO<ThirdMenuDTO> queryAThirdMenu(Integer id, Integer parentMenuId);

    /**
     * 添加三级菜单
     * @param thirdMenuDTO 三级菜单数据传输对象
     * @return 操作信息message
     */
    JsonVO<String> saveThirdMenu(ThirdMenuDTO thirdMenuDTO);

    /**
     * 修改三级菜单
     * @param thirdMenuDTO 三级菜单数据传输对象
     * @return 操作信息message
     */
    JsonVO<String> modifyThirdMenu(ThirdMenuDTO thirdMenuDTO);

    /**
     * 删除三级菜单(根据角色名称和菜单id)
     * @param menuId 三级菜单ID
     * @return 操作信息message
     */
    JsonVO<String> removeThirdMenu(String roleName, Integer menuId);
}
