package com.zeroone.star.scoauth2.service.impl;

import com.zeroone.star.project.constant.RedisConstant;
import com.zeroone.star.project.utils.redis.RedisUtils;
import com.zeroone.star.scoauth2.entity.Menu;
import com.zeroone.star.scoauth2.entity.Role;
import com.zeroone.star.scoauth2.service.IMenuService;
import com.zeroone.star.scoauth2.service.IRoleService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * @Description 路径与角色资源服务器初始化服务
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Service
public class ResourceServiceImpl {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private IMenuService menuService;
    @Resource
    private IRoleService roleService;

    @PostConstruct
    public void init() {
        // 定义缓存map
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        // 1 获取所有菜单
        List<Menu> tMenus = menuService.listAllLinkUrl();
        tMenus.forEach(menu -> {
            // 2 获取菜单对应的角色
            List<Role> rolesMenu = roleService.listRoleByMenuPath(menu.getLinkUrl());
            List<String> roles = new ArrayList<>();
            rolesMenu.forEach(role -> roles.add(role.getKeyword()));
            resourceRolesMap.put(menu.getLinkUrl(), roles);
        });

        //将资源缓存到redis
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
