package com.zeroone.star.sccommonmenu.mapper;

import com.zeroone.star.sccommonmenu.entity.MMenuUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-15
 */
@Mapper
public interface MMenuUserMapper extends BaseMapper<MMenuUser> {
    boolean changeMMenUserStatusCd(@Param("muId") String muId, @Param("staffId") String staffId, @Param("statusCd") int statusCd);
}
