package com.zeroone.star.sccommunity.service.repairmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.repairmanagement.OwnerRepairManageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.OwnerRepairManageVO;
import com.zeroone.star.sccommunity.entity.dict.TDict;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairPool;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairSetting;
import com.zeroone.star.sccommunity.mapper.dict.DictTDictMapper;
import com.zeroone.star.sccommunity.mapper.repairmanagement.RRepairPoolMapper;
import com.zeroone.star.sccommunity.mapper.repairmanagement.RRepairSettingMapper;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairPoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
@Service
public class RRepairPoolServiceImpl extends ServiceImpl<RRepairPoolMapper, RRepairPool> implements IRRepairPoolService {

    @Autowired
    RRepairPoolMapper rRepairPoolMapper;

    @Autowired
    RRepairSettingMapper rRepairSettingMapper;

    @Autowired
    DictTDictMapper tDictMapper;

    @Override
    public PageVO<OwnerRepairManageVO> listByCondition(OwnerRepairManageQuery condition) {
        /* condition
        page: 1
        row: 10
        communityId: 2022090665021542
        repairObjId: 752022100910441032
         */

        // 返回的Page对象
        Page<OwnerRepairManageVO> resultPage = new Page<>();

        // 查询用的Page对象
        Page<RRepairPool> pageInfo = new Page<>(condition.getPage(), condition.getRow());
        LambdaQueryWrapper<RRepairPool> rRepairPoolLambdaQueryWrapper = new LambdaQueryWrapper();
        rRepairPoolLambdaQueryWrapper.eq(StringUtils.isNotBlank(condition.getCommunityId()), RRepairPool::getCommunityId, condition.getCommunityId())
                .eq(StringUtils.isNotBlank(condition.getRepairObjId()), RRepairPool::getRepairObjId, condition.getRepairObjId())
                .eq(StringUtils.isNotBlank(condition.getRepairId()), RRepairPool::getRepairId, condition.getRepairId());
        rRepairPoolMapper.selectPage(pageInfo, rRepairPoolLambdaQueryWrapper);

        // 把查询出的Page对象值拷贝到结果resultPage对象，records不拷贝后面处理
        BeanUtils.copyProperties(pageInfo, resultPage, "records");

        // 拿到数据里面的记录做个处理
        List<RRepairPool> records = pageInfo.getRecords();

        List<OwnerRepairManageVO> ownerRepairManageVOList = records.stream().map((item) -> {
            OwnerRepairManageVO ownerRepairManageVO = new OwnerRepairManageVO();
            BeanUtils.copyProperties(item, ownerRepairManageVO);

            LambdaQueryWrapper<RRepairSetting> rRepairSettingLambdaQueryWrapper = new LambdaQueryWrapper<>();
            rRepairSettingLambdaQueryWrapper.eq(StringUtils.isNotBlank(ownerRepairManageVO.getRepairType()), RRepairSetting::getRepairType, ownerRepairManageVO.getRepairType());
            RRepairSetting rRepairSetting = rRepairSettingMapper.selectOne(rRepairSettingLambdaQueryWrapper);

            BeanUtils.copyProperties(rRepairSetting, ownerRepairManageVO);

            LambdaQueryWrapper<TDict> tDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
            /*
            这里应该是status_cd字段，然而不知道json为啥是state
             */
            tDictLambdaQueryWrapper.eq(StringUtils.isNotBlank(ownerRepairManageVO.getState()), TDict::getStatusCd, ownerRepairManageVO.getState());
            TDict tDict = tDictMapper.selectOne(tDictLambdaQueryWrapper);

            ownerRepairManageVO.setStateName(tDict.getName());

            return ownerRepairManageVO;
        }).collect(Collectors.toList());

        resultPage.setRecords(ownerRepairManageVOList);

        return PageVO.create(resultPage);
    }


}
