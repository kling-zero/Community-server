package com.zeroone.star.scoauth2.service.impl;

import com.zeroone.star.scoauth2.entity.Role;
import com.zeroone.star.scoauth2.mapper.RoleMapper;
import com.zeroone.star.scoauth2.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 阿伟
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> listRoleByUserId(int userId) {
        return baseMapper.selectByUserId(userId);
    }

    @Override
    public List<Role> listRoleByMenuPath(String path) {
        return baseMapper.selectByMenuPath(path);
    }
}
