package com.zeroone.star.scmenu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.scmenu.entity.Role;

import java.util.List;


/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
public interface IRoleService extends IService<Role> {
    //获得所有归属商户
    List<Role> getAllList();

    public Role getOneByName(String roleName);
}
