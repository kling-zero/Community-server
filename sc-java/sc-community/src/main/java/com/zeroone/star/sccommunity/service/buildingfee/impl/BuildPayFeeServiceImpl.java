package com.zeroone.star.sccommunity.service.buildingfee.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.dto.community.transactions.buildingfee.TempFeeDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.BuildingFeesQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.sccommunity.entity.buildingfee.*;
import com.zeroone.star.sccommunity.mapper.buildingfee.BuildPayFeeMapper;
import com.zeroone.star.sccommunity.service.buildingfee.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

import static cn.hutool.poi.excel.sax.AttributeName.s;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 今日运势大吉
 * @since 2022-10-21
 */
@Service
public class BuildPayFeeServiceImpl extends ServiceImpl<BuildPayFeeMapper, PayFee> implements IPayFeeService {
    @Resource
    private ITDictService tDictService;
    @Resource
    private IPayFeeConfigService payFeeConfigService;
    @Resource
    private IBillOweFeeService billOweFeeService;
    @Resource
    private ICStatusService icStatusService;
    @Resource
    private IPayFeeBatchService iPayFeeBatchService;
    @Resource
    private IImportFeeService iImportFeeService;
    @Resource
    private IImportFeeDetailService iImportFeeDetailService;
    @Resource
    private IPayFeeAttrsService payFeeAttrsService;

    /**
     * 分页查询房屋费用
     *
     * @param condition 查询条件
     * @return 分页查询结果
     */
    @Override
    public PageVO<FeesVO> queryPayFee(BuildingFeesQuery condition) {
        //构建分页查询条件
        Page<PayFee> page = new Page(condition.getPageIndex(), condition.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<PayFee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayFee::getCommunityId, condition.getCommunityId());
        queryWrapper.eq(condition.getPayerObjType() != null, PayFee::getPayerObjType, condition.getPayerObjType());
        queryWrapper.eq(condition.getFeeTypeCd() != null, PayFee::getFeeTypeCd, condition.getFeeTypeCd());
        queryWrapper.eq(condition.getConfigId() != null, PayFee::getConfigId, condition.getConfigId());
        queryWrapper.eq(condition.getState() != null, PayFee::getState, condition.getState());
        queryWrapper.eq(condition.getPayerObjId() != null, PayFee::getPayerObjId, condition.getPayerObjId());
        queryWrapper.orderByDesc(PayFee::getStartTime);
        Page<PayFee> payFeePage = baseMapper.selectPage(page, queryWrapper);
        //如果获取条数为0，直接返回
        if (payFeePage.getTotal() == 0) {
            return PageVO.create(payFeePage, FeesVO.class);
        }
        //设置费用类型、费用标识、状态，通过id展示名称
        for (PayFee payFee : payFeePage.getRecords()) {
            //费用标识的名称
            String feeFlagName = tDictService.tDictGetNameByPayFee(payFee.getFeeFlag());
            //费用类型的名称
            String feeTypeCdName = tDictService.tDictGetNameByPayFeeConfig(payFee.getFeeTypeCd());
            //收费状态名称
            String stateName = tDictService.tDictGetNameByPayFee(payFee.getState());
            if (feeFlagName != null) {
                payFee.setFeeFlag(feeFlagName);
            } else {
                payFee.setFeeFlag("其他");
            }
            if (feeTypeCdName != null) {
                payFee.setPayerObjType(feeTypeCdName);
            } else {
                payFee.setFeeTypeCd("其他");
            }
            if (stateName != null) {
                payFee.setState(stateName);
            } else {
                payFee.setState("其他");
            }
        }
        //设置费用项名称
        for (PayFee payFee : payFeePage.getRecords()) {
            LambdaQueryWrapper<PayFeeConfig> configQueryWrapper = new LambdaQueryWrapper<>();
            configQueryWrapper.eq(PayFeeConfig::getConfigId, payFee.getConfigId());
            PayFeeConfig payFeeConfig = payFeeConfigService.getOne(configQueryWrapper);
            if (payFeeConfig != null) {
                payFee.setFeeId(payFeeConfig.getFeeName());
            } else {
                payFee.setFeeId("其他");
            }
        }
        //设置计费结束时间
        for (PayFee payFee : payFeePage.getRecords()) {
            LambdaQueryWrapper<BillOweFee> wrapper3 = new LambdaQueryWrapper<>();
            wrapper3.eq(BillOweFee::getFeeId, payFee.getFeeId());
            wrapper3.eq(BillOweFee::getCommunityId, payFee.getCommunityId());
            BillOweFee billOweFee = billOweFeeService.getOne(wrapper3);
            if (billOweFee != null) {
                payFee.setDeadlineTime(billOweFee.getDeadlineTime());
            } else {
                payFee.setDeadlineTime(payFee.getEndTime());
            }
        }
        //返回分页查询结果
        return PageVO.create(payFeePage, FeesVO.class);
    }

    /**
     * 添加临时收费
     *
     * @param dto 传入数据
     */
    @Override
    public void saveTempFee(TempFeeDTO dto) {
        Snowflake snowflake = IdUtil.getSnowflake();
        String feeId = snowflake.nextIdStr();
        String payFeeConfigId = snowflake.nextIdStr();
        String feeBatchId = snowflake.nextIdStr();
//        // 费用表 pay_fee
        PayFee payFee = new PayFee();
        BeanUtils.copyProperties(dto, payFee);
        payFee.setFeeId(feeId);
        //添加数据到pay_fee_batch表中
        PayFeeBatch payFeeBatch = new PayFeeBatch();
        payFeeBatch.setBatchId(feeBatchId);
        BeanUtils.copyProperties(dto, payFeeBatch);
        payFeeBatch.setBatchId(feeBatchId);
        payFeeBatch.setCreateUserName("wuxw");
        payFeeBatch.setCreateUserId("302021080447630001");
        payFeeBatch.setCreateTime(LocalDateTime.now());
        payFeeBatch.setState("2006001");
        payFeeBatch.setMsg("正常");
        iPayFeeBatchService.save(payFeeBatch);

        payFee.setBatchId(payFeeBatch.getBatchId());
        payFee.setUserId(payFeeBatch.getCreateUserName());
        payFee.setIncomeObjId(payFeeBatch.getCreateUserId());
        baseMapper.insert(payFee);

        // 费用导入日志表 import_fee
        ImportFee importFee = new ImportFee();
//        String importFeeId = String.valueOf(UUID.randomUUID());
//        importFee.setImportFeeId(importFeeId);
//        importFee.setFeeTypeCd(dto.getFeeTypeCd());
//        importFee.setCommunityId(dto.getCommunityId());
        BeanUtils.copyProperties(dto, importFee);
        iImportFeeService.save(importFee);

        // 费用导入明细表 import_fee_detail
        ImportFeeDetail importFeeDetail = new ImportFeeDetail();
        BeanUtils.copyProperties(dto, importFeeDetail);
        String importFeeId = snowflake.nextIdStr();
        importFeeDetail.setImportFeeId(importFeeId);
        String objName = dto.getObjName();
        String floor_num = objName.substring(0, objName.lastIndexOf("栋"));
        String unit_num = objName.substring(objName.indexOf("栋") + 1, objName.lastIndexOf("单元"));
        String room_num = objName.substring(objName.indexOf("单元") + 2, objName.lastIndexOf("室"));
        importFeeDetail.setFloorNum(floor_num);
        importFeeDetail.setUnitNum(unit_num);
        importFeeDetail.setRoomNum(room_num);
        importFeeDetail.setFeeId(feeId);
        importFeeDetail.setState("1000");
        iImportFeeDetailService.save(importFeeDetail);

        // 费用属性表 pay_fee_attrs
        PayFeeAttrs payFeeAttrs = new PayFeeAttrs();
        payFeeAttrs.setFeeId(payFee.getFeeId());

        payFeeAttrsService.save(payFeeAttrs);
        // 费用配置 pay_fee_config
        for (FeeConfigsVO feeConfig : dto.getFeeConfigs()) {
            PayFeeConfig payFeeConfig = payFeeConfigService.getById(feeConfig.getConfigId());
            if (payFeeConfig != null) {
                PayFeeConfig payFeeConfigTemp = new PayFeeConfig();
                payFeeConfigTemp.setConfigId(feeConfig.getConfigId());
                payFeeConfigTemp.setCommunityId(dto.getCommunityId());
                payFeeConfigTemp.setFeeTypeCd(feeConfig.getFeeTypeCd());
                payFeeConfigTemp.setSquarePrice(feeConfig.getSquarePrice());
                payFeeConfigTemp.setAdditionalAmount(feeConfig.getAdditionalAmount());
                payFeeConfigTemp.setIsDefault(feeConfig.getIsDefault());
                payFeeConfigTemp.setStartTime(dto.getStartTime());
                payFeeConfigTemp.setEndTime(dto.getEndTime());
                payFeeConfigTemp.setFeeFlag(feeConfig.getFeeFlag());
                payFeeConfigTemp.setFeeName(feeConfig.getFeeName());
                payFeeConfigTemp.setComputingFormula(feeConfig.getComputingFormula());
                payFeeConfigTemp.setBillType(feeConfig.getBillType());
                payFeeConfigTemp.setPaymentCycle(feeConfig.getPaymentCycle());
                payFeeConfigTemp.setPaymentCd(feeConfig.getPaymentCd());
                payFeeConfigTemp.setDeductFrom(feeConfig.getDeductFrom());
                payFeeConfigService.save(payFeeConfig);
            }
        }
        //c_status
        for (FeeTypeCdsVO feeTypeCd : dto.getFeeTypeCds()) {
            if (icStatusService.getById(feeTypeCd.getId()) == null) {
                CStatus cStatus = new CStatus();
                cStatus.setId(feeTypeCd.getId());
                cStatus.setName(feeTypeCd.getName());
                cStatus.setDescription(feeTypeCd.getDescription());
                cStatus.setStatusCd(feeTypeCd.getStatusCd());
                icStatusService.save(cStatus);
            }
        }
    }
}
