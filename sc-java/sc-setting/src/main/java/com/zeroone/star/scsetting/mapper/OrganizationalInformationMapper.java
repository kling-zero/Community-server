package com.zeroone.star.scsetting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.scsetting.entity.OrganizationalInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author insist
 * @since 2022-10-15
 */
@Mapper
public interface OrganizationalInformationMapper extends BaseMapper<OrganizationalInformation> {
    @Select("select count(*) from zosc_tt.business_user where tel=#{tel} limit 1")
    Integer isExistTel(@Param("tel") String tel);

    @Update("update zosc_tt.business_user set password = #{password} where id = #{id}")
    Integer updateById(@Param("id") Long id, @Param("password") String password);
}
