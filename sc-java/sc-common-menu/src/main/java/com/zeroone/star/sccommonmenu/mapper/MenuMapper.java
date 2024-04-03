package com.zeroone.star.sccommonmenu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;
import com.zeroone.star.sccommonmenu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 分级别，根据三级菜单id，向上找，
     * @param ids
     * @return
     * {
     *     一级{
     *         二级{
     *             三级{
     *
     *             }
     *             ......
     *         }
     *         .....
     *     }
     *     .....
     * }
     */
    List<TreeMenuVO> getAllByIdListL3(List<Integer> ids);
    List<TreeMenuVO> getAllByIdListL2(List<Integer> ids);
    List<TreeMenuVO> getAllByIdListL1(List<Integer> ids);
    List<TreeMenuVO> getAllByIdList(List<Integer> ids);

    /**
     * 不分级别，直接返回菜单列表
     * @param ids
     * @return
     */
    List<TreeMenuVO> getAllByIdListNoLevel(List<Integer> ids);
}
