package com.zeroone.star.scsetting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.scsetting.entity.Organization;
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
public interface OrganizationMapper extends BaseMapper<Organization> {

}
