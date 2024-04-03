package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.MMenuGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
public interface IMMenuGroupService extends IService<MMenuGroup> {
    /**
     * 通过name获得物业功能信息
     * @param name 物业功能名称
     * @return 物业功能信息
     */
    public MMenuGroup getMMenuGroupByName(String name);

    /**
     *
     * @return
     */
    List<MMenuGroup> getALlMenu() ;
}
