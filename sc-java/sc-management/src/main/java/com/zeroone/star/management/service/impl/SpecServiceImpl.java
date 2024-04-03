package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.management.entity.Spec;
import com.zeroone.star.management.mapper.SpecMapper;
import com.zeroone.star.management.service.ISpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements ISpecService {

    @Autowired
    SpecMapper specMapper;

    @Override
    public Spec getSpecByName(String name) {
        QueryWrapper<Spec> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        Spec spec = specMapper.selectOne(queryWrapper);
        return spec;
    }
}
