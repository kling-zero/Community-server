package com.zeroone.star.sccommunity.service.buildingfee;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.sccommunity.entity.buildingfee.TDict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
public interface ITDictService extends IService<TDict> {
    /**
     * 根据对应类别查询名称
     * @param statusCd 类别参数
     * @return 名称
     */
    String tDictGetNameByPayFeeConfig(String statusCd);


    String tDictGetNameByPayFee(String statusCd);
}
