package com.zeroone.star.sccommunity.mapper.prrmanagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommunity.entity.prrmanagement.Check;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CheckMapper extends BaseMapper<Check> {
}
