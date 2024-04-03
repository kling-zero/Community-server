package com.zeroone.star.scsetting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.scsetting.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: MFM
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update zosc_tt.u_user set password = #{password} where id = #{id}")
    Integer updateById(@Param("id") Long id, @Param("password") String password);
}
