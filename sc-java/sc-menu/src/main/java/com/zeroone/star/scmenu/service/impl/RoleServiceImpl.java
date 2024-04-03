
package com.zeroone.star.scmenu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zeroone.star.scmenu.entity.Role;
import com.zeroone.star.scmenu.mapper.RoleMapper;
import com.zeroone.star.scmenu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public boolean save(Role entity) {
        return super.save(entity);
    }

    @Autowired
    private RoleMapper roleMapper;

    //获得所有归属商户
    @Override
    public List<Role> getAllList() {
        List<Role> roleList = this.list();
        return roleList;
    }

    public Role getOneByName(String roleName) {
        Role role = roleMapper.getOneByName(roleName);
        return role;
    }

}
