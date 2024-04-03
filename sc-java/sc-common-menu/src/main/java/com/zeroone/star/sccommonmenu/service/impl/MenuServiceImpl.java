package com.zeroone.star.sccommonmenu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;
import com.zeroone.star.sccommonmenu.entity.Menu;
import com.zeroone.star.sccommonmenu.mapper.MenuMapper;
import com.zeroone.star.sccommonmenu.service.IMenuService;
import com.zeroone.star.sccommonmenu.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private IRoleMenuService roleMenuService;

    @Autowired
    private MenuMapper menuMapper;

    public List<TreeMenuVO> treeMenuVOList(){
        String userId = "2";
        //获得菜单Id
        List<Integer> menuIds = roleMenuService.getMenuByRole(userId);

        //获得菜单列表
        //三级菜单
        //List<TreeMenuVO> treeMenuVOListL3 = menuMapper.getAllByIdListL3(menuIds);
        //二级菜单
        //List<TreeMenuVO> treeMenuVOListL2 = menuMapper.getAllByIdListL2(menuIds);
        //一级菜单
        //List<TreeMenuVO> treeMenuVOListL1 = menuMapper.getAllByIdListL1(menuIds);
        //合并
        //treeMenuVOListL1.addAll(treeMenuVOListL2);
        //treeMenuVOListL1.addAll(treeMenuVOListL3);

        //根据二级菜单获得
        /**
         * 一级{
         *     二级{
         *
         *     }
         *     ....
         * }
         * ....
         */
        //这样的结构
        List<TreeMenuVO> treeMenuVOList = menuMapper.getAllByIdList(menuIds);

        return treeMenuVOList;
    }
}
