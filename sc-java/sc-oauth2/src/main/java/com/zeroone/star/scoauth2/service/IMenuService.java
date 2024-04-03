package com.zeroone.star.scoauth2.service;

import com.zeroone.star.scoauth2.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author 阿伟
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 获取菜单中的链接地址
     * @return 查询结果
     */
    List<Menu> listAllLinkUrl();
}
