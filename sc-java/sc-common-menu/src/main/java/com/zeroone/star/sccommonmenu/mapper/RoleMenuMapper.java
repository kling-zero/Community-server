package com.zeroone.star.sccommonmenu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommonmenu.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 Mapper 接口
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    List<String> getMenuByRole();
}
