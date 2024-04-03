package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.Spec;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
public interface ISpecService extends IService<Spec> {
    /**
     * 通过name获得相关信息
     * @param name 属性名称
     * @return 属性相关信息
     */
    public Spec getSpecByName(String name);
}
