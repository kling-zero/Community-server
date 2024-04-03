package com.zeroone.star.sccommunity.service.repairmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairStaffQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.OwnerRepairManageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairStaffVO;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairUser;
import com.zeroone.star.sccommunity.mapper.repairmanagement.RRepairUserMapper;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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
 * @since 2022-10-15
 */
@Service
public class RRepairUserServiceImpl extends ServiceImpl<RRepairUserMapper, RRepairUser> implements IRRepairUserService {

    @Autowired
    RRepairUserMapper rRepairUserMapper;

    @Override
    public PageVO<RepairStaffVO> listAllRepairStaff(RepairStaffQuery condition) {
        // 返回的Page对象
        Page<RepairStaffVO> resultPage = new Page<>();

        // 查询用的Page对象
        Page<RRepairUser> pageInfo = new Page<>(condition.getPage(), condition.getRow());
        LambdaQueryWrapper<RRepairUser> rRepairUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rRepairUserLambdaQueryWrapper.eq(RRepairUser::getCommunityId, condition.getCommunityId())
                .eq(RRepairUser::getRepairId, condition.getRepairId());
        rRepairUserMapper.selectPage(pageInfo, rRepairUserLambdaQueryWrapper);

        // 把查询出的Page对象值拷贝到结果resultPage对象，records不拷贝后面处理
        BeanUtils.copyProperties(pageInfo, resultPage, "records");

        // 拿到数据里面的记录做个处理
        List<RRepairUser> records = pageInfo.getRecords();

        List<RepairStaffVO> repairStaffVOList = records.stream().map((item) -> {
            RepairStaffVO repairStaffVO = new RepairStaffVO();
            BeanUtils.copyProperties(item, repairStaffVO);
            // 得到时间差，转换格式赋给duration
            Duration duration = Duration.between(repairStaffVO.getStartTime(), repairStaffVO.getEndTime());
            repairStaffVO.setDuration(LocalTime.ofNanoOfDay(duration.toNanos()).format(DateTimeFormatter.ofPattern("HH:mm:ss")));

            repairStaffVO.setPage(-1);
            repairStaffVO.setPhotoVos(null);
            repairStaffVO.setRecords(0);
            repairStaffVO.setRow(0);
            // 前端处理？
            // repairStaffVO.setStateName("已派单");
            repairStaffVO.setTotal(0);

            return repairStaffVO;
        }).collect(Collectors.toList());

        resultPage.setRecords(repairStaffVOList);

        return PageVO.create(resultPage);
    }

//    public static void main(String[] args) {
//        String start = "2010-02-02 01:01:01";
//        String end = "2010-02-02 03:03:03";
//
//        LocalDateTime startDateTime = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDateTime endDateTime = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//        Duration duration = Duration.between(startDateTime, endDateTime);
//        System.out.println(LocalTime.ofNanoOfDay(duration.toNanos()).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//    }
}
