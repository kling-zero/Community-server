package com.zeroone.star.sccommunity.service.repairmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairSettingQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairStaffVO;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairSetting;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairUser;
import com.zeroone.star.sccommunity.mapper.repairmanagement.RRepairSettingMapper;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-16
 */
@Service
public class RRepairSettingServiceImpl extends ServiceImpl<RRepairSettingMapper, RRepairSetting> implements IRRepairSettingService {

    @Autowired
    RRepairSettingMapper rRepairSettingMapper;

    @Override
    public PageVO<RepairSettingVO> listAllRepairSetting(RepairSettingQuery condition) {
        // 返回的Page对象
        Page<RepairSettingVO> resultPage = new Page<>();

        // 查询用的Page对象
        Page<RRepairSetting> pageInfo = new Page<>(condition.getPage(), condition.getRow());
        LambdaQueryWrapper<RRepairSetting> rRepairSettingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rRepairSettingLambdaQueryWrapper.eq(RRepairSetting::getCommunityId, condition.getCommunityId())
                .eq(RRepairSetting::getPublicArea, condition.getPublicArea());
        rRepairSettingMapper.selectPage(pageInfo, rRepairSettingLambdaQueryWrapper);

        // 把查询出的Page对象值拷贝到结果resultPage对象，records不拷贝后面处理
        BeanUtils.copyProperties(pageInfo, resultPage, "records");

        // 拿到数据里面的记录做个处理
        List<RRepairSetting> records = pageInfo.getRecords();

        List<RepairSettingVO> repairSettingVOList = records.stream().map((item) -> {
            RepairSettingVO repairSettingVO = new RepairSettingVO();
            BeanUtils.copyProperties(item, repairSettingVO);
            /*
            "repairSettingTypeName":"维修单",
            "repairWayName":"指派",
            "returnVisitFlagName":"已评价不回访",
             */
            repairSettingVO.setPage(-1);
            repairSettingVO.setRecords(0);
            repairSettingVO.setRow(0);
            repairSettingVO.setTotal(0);

            return repairSettingVO;

        }).collect(Collectors.toList());

        resultPage.setRecords(repairSettingVOList);

        return PageVO.create(resultPage);
    }
}
