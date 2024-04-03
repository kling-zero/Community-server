package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.SStoreAttr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.management.entity.Spec;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
public interface ISStoreAttrService extends IService<SStoreAttr> {

    /**
     * 添加物业公司法人信息
     * @param spec 公司法人属性相关信息
     * @param corporation 公司法人名字
     * @return
     */
    public int insertSStoreAttr(Spec spec,String corporation,String storeID);

    /**
     * 通过物业ID修改公司法人
     * @param id 物业ID
     * @param value 修改后的公司法人
     * @return  修改结果
     */
    public int updateSStroeAttrValueById(String id,String value);
}
