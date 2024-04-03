package com.zeroone.star.scmenu.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.menu.SecondaryMenuVO;
import com.zeroone.star.project.vo.menu.ThirdMenuVO;
import com.zeroone.star.scmenu.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {


    Page<ThirdMenuDTO> selectThirdMenuByParentId(int parentId, Page<ThirdMenuDTO> page);

    ThirdMenuDTO getThirdMenu(@Param("id") Integer id,@Param("roleId") Integer roleId);

    Page<FirstMenuDTO> selectFirstMenu(@Param("firstMenuPageQuery") FirstMenuPageQuery firstMenuPageQuery, Page<FirstMenuDTO> page);

    FirstMenuDTO getFirstMenu(@Param("id") Integer id, @Param("roleId") Integer roleId);

    Page<ThirdMenuVO> selectThirdMenu(@Param("thirdMenuPageQuery") ThirdMenuPageQuery thirdMenuPageQuery, Page<Menu> page);

    ThirdMenuDTO selectAThirdMenu(@Param("id") Integer id, @Param("parentMenuId") Integer parentMenuId);

    int updateThirdMenu(@Param("thirdMenuDTO") ThirdMenuDTO thirdMenuDTO);

    int deleteThirdMenuById(@Param("menuId") Integer menuId);

    Integer selectRoleIdByRoleName(@Param("roleName") String roleName);

    Integer selectExistMenuByParentId(@Param("parentMenuId") Integer parentMenuId);

    Integer selectExistMenuById(@Param("id") Integer id);
    List<SecondaryMenuVO> selectSubmenu();

    boolean updateIsEnable(@Param("id")Integer id);
}
