package com.zeroone.star.sccommunity.service.structure.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.mapper.structure.StrTDictMapper;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 根据提供的状态码，表名，表的字段来查询对应的状态名称
 */
@Service
public class StrTDictServiceImpl extends ServiceImpl<StrTDictMapper, TDict> implements ITDictService {
    @Resource
    StrTDictMapper tDictMapper;

    @Override
    public TDict selectByStatus(String status, String tableName, String tableColumns) {
        QueryWrapper<TDict> wrapper = new QueryWrapper<>();
        wrapper.eq("status_cd",status)
                .eq("table_name",tableName)
                .eq("table_columns",tableColumns);
        TDict tDict = tDictMapper.selectOne(wrapper);
        return tDict;
    }
}
