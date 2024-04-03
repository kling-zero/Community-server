package com.zeroone.star.sccommunity.mapper.prrmanagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PRRMapper extends BaseMapper<PRR> {
}
