package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.sccommunity.entity.buildingfee.TDict;
import com.zeroone.star.sccommunity.mapper.buildingfee.TDictMapper;
import com.zeroone.star.sccommunity.service.buildingfee.ITDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Service
@Slf4j
public class TDictServiceImpl extends ServiceImpl<TDictMapper, TDict> implements ITDictService {
    /**
     * 根据对应类别查询名称
     * @param statusCd 类别参数
     * @return 名称
     */
    @Override
    public String tDictGetNameByPayFeeConfig(String statusCd){
        //获取名称 --- 计算公式、周期类别、费用类别、费用标识等
        LambdaQueryWrapper<TDict> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(statusCd != null, TDict::getStatusCd, statusCd);
        queryWrapper.eq(TDict::getTableName, "pay_fee_config");
        List<TDict> list = super.list(queryWrapper);
        //如果对象不为空，则获取其名称
        if (list.get(0) != null) {
            TDict tDict = list.get(0);
            return tDict.getName();
        }
        return "";
    }

    @Override
    public String tDictGetNameByPayFee(String statusCd) {
        //获取名称 --- 计算公式、周期类别、费用类别、费用标识等
        LambdaQueryWrapper<TDict> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(statusCd != null, TDict::getStatusCd, statusCd);
        queryWrapper.eq(TDict::getTableName, "pay_fee");
        List<TDict> list = super.list(queryWrapper);
        //如果对象不为空，则获取其名称
        if (list.get(0) != null) {
            TDict tDict = list.get(0);
            return tDict.getName();
        }
        return "";
    }
}
