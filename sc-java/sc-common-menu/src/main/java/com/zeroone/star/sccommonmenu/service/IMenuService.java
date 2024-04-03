package com.zeroone.star.sccommonmenu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;
import com.zeroone.star.sccommonmenu.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
public interface IMenuService extends IService<Menu> {
    List<TreeMenuVO> treeMenuVOList();
}
