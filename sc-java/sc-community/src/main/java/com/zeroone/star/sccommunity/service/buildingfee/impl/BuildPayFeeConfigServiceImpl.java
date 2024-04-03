package com.zeroone.star.sccommunity.service.buildingfee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.query.community.transactions.buildingfee.FeeConfigsQuery;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFeeConfig;
import com.zeroone.star.sccommunity.mapper.buildingfee.PayFeeConfigMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IPayFeeConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.service.buildingfee.ITDictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Service
public class BuildPayFeeConfigServiceImpl extends ServiceImpl<PayFeeConfigMapper, PayFeeConfig> implements IPayFeeConfigService {
    @Resource
    private ITDictService tDictService;

    @Autowired
    PayFeeConfigMapper payFeeConfigMapper;

    @Override
    public PayFeeConfig selectByConfigId(String configId) {
        QueryWrapper<PayFeeConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("config_id",configId);
        PayFeeConfig payFeeConfig = payFeeConfigMapper.selectOne(wrapper);
        return payFeeConfig;
    }

    @Override
    public List<FeeConfigsVO> listFeeConfigs(FeeConfigsQuery condition) {
        //添加查询条件
        LambdaQueryWrapper<PayFeeConfig> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayFeeConfig::getCommunityId, condition.getCommunityId());
        queryWrapper.eq(condition.getFeeTypeCd() != null, PayFeeConfig::getFeeTypeCd, condition.getFeeTypeCd());
        queryWrapper.eq(PayFeeConfig::getIsDefault, condition.getIsDefault());
        //执行分页查询
        List<PayFeeConfig> list = super.list(queryWrapper);

        //拷贝数据
        List<FeeConfigsVO> feeConfigsList = list.stream().map((item) -> {
            FeeConfigsVO feeConfigsVO = new FeeConfigsVO();
            BeanUtils.copyProperties(item, feeConfigsVO);
            return feeConfigsVO;
        }).collect(Collectors.toList());

        for (int i = 0; i < feeConfigsList.size(); i++) {
            FeeConfigsVO feeConfigsVO = feeConfigsList.get(i);
            //获取计算公式名称
            String computingFormula = feeConfigsVO.getComputingFormula();
            String computingFormulaName = tDictService.tDictGetNameByPayFeeConfig(computingFormula);
            feeConfigsVO.setComputingFormulaName(computingFormulaName);
            //获取周期类别名称
            String billType = feeConfigsVO.getBillType();
            String billTypeName = tDictService.tDictGetNameByPayFeeConfig(billType);
            feeConfigsVO.setBillTypeName(billTypeName);
            //获取费用标识名称
            String feeFlag = feeConfigsVO.getFeeFlag();
            String feeFlagName = tDictService.tDictGetNameByPayFeeConfig(feeFlag);
            feeConfigsVO.setFeeFlagName(feeFlagName);
            //获取费用类别名称
            String feeTypeCd = feeConfigsVO.getFeeTypeCd();
            String feeTypeCdName = tDictService.tDictGetNameByPayFeeConfig(feeTypeCd);
            feeConfigsVO.setFeeTypeCdName(feeTypeCdName);
        }
        return feeConfigsList;
    }
}
