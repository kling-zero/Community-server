package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.mapper.MMenuGroupMapper;
import com.zeroone.star.management.service.IMMenuGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
@Service
public class MMenuGroupServiceImpl extends ServiceImpl<MMenuGroupMapper, MMenuGroup> implements IMMenuGroupService {

    @Autowired
    MMenuGroupMapper mMenuGroupMapper;
    @Override
    public MMenuGroup getMMenuGroupByName(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        List<MMenuGroup> list = mMenuGroupMapper.selectByMap(map);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<MMenuGroup> getALlMenu() {
        //查询正在使用的菜单列表
        LambdaQueryWrapper<MMenuGroup> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MMenuGroup::getStoreType,"800900000003")
                .eq(MMenuGroup::getStatusCd,"0")
                .orderByAsc(MMenuGroup::getSeq);
        return mMenuGroupMapper.selectList(queryWrapper);
    }
}
