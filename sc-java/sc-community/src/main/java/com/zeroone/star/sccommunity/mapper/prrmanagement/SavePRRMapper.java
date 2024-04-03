package com.zeroone.star.sccommunity.mapper.prrmanagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import com.zeroone.star.sccommunity.entity.prrmanagement.SavePRR;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SavePRRMapper extends BaseMapper<SavePRR> {
}
