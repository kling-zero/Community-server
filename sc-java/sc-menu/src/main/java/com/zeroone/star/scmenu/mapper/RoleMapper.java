package com.zeroone.star.scmenu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.scmenu.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Role getOneByName(@Param("roleName") String roleName);
}
