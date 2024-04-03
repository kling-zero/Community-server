package com.zeroone.star.project.menu;

import com.zeroone.star.project.dto.menu.MenugroupDTO;
import com.zeroone.star.project.dto.menu.SecondaryMenuDTO;
import com.zeroone.star.project.query.menu.MenugroupQuery;
import com.zeroone.star.project.query.menu.SecondaryMenuQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.MenugroupVO;
import com.zeroone.star.project.vo.menu.SecondaryMenuVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author xcx
 * @date
 */
public interface SecondaryMenuApis {
    //二级菜单
    //选择菜单组，新增菜单信息
    JsonVO<String> saveSubmenu(SecondaryMenuDTO secondaryMenuDTO);
    //修改菜单信息
    JsonVO<SecondaryMenuVO> updateSubmenu(SecondaryMenuDTO secondaryMenuDTO,Integer secondaryMenuId) throws Exception;
    //删除菜单信息
    JsonVO<String> deleteSubmenu(Integer Id, String roleName);
    //查询菜单信息
    JsonVO<List<SecondaryMenuVO>> selectSubmenu(SecondaryMenuQuery query);
}
