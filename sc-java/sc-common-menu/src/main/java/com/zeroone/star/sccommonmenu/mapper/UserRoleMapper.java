package com.zeroone.star.sccommonmenu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommonmenu.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<String> getRoleByuserId(@Param("userId") String userId);
}
