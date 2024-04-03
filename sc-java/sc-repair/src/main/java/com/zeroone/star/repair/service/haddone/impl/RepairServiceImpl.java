package com.zeroone.star.repair.service.haddone.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.repair.handone.RepairQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.haddone.RepairDetailVO;
import com.zeroone.star.project.vo.repair.haddone.RepairVO;
import com.zeroone.star.repair.entity.haddone.*;
import com.zeroone.star.repair.mapper.haddone.*;
import com.zeroone.star.repair.service.haddone.IRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author awei
 * @since 2022-10-08
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {

    @Autowired
    RepairMapper repairMapper;
    @Autowired
    RepairTypeMapper repairTypeMapper;
    @Autowired
    RepairStateMapper repairStateMapper;
    @Autowired
    CommunityMapper communityMapper;
    @Autowired
    RepairTypeNameMapper repairTypeNameMapper;
    @Autowired
    RepairDetailMapper repairDetailMapper;
    @Autowired
    RevisitContextMapper revisitContextMapper;

    /**
     * 查询所有
     *
     * @param query 分页数据
     * @return
     */
    @Override
    public PageVO<RepairVO> listAll(PageQuery query) {
        //构建分页对象
        Page<Repair> page = new Page<>(query.getPageIndex(), query.getPageSize());
        //构建条件对象
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();

        //报修已办的过滤条件是状态为办理完成(状态码1900)或者电话回访（状态码1800）
        wrapper.eq("state", "1900").or().eq("state", "1800").or().eq("state", "1000");

        //执行分页查询,baseMapper是因为加了@Mapper；
        Page<Repair> pages = repairMapper.selectPage(page, wrapper);

        //将小区id、维修类型id、状态id转为具体的名称
        for (Repair repair : pages.getRecords()) {
            //转换小区名
            parseCommunity(repair);
            //转换状态为名称
            parseState(repair);
            //转换类型名称
            parseRepairTypeName(repair);
            //System.out.println(repair);
        }

        return PageVO.create(pages, RepairVO.class);
    }

    @Override
    public PageVO<RepairVO> listAllConditions(RepairQuery query) {
        return null;
    }

    /**
     * 转换小区名称
     *
     * @param repair
     */
    public void parseCommunity(Repair repair) {
        String communityId = repair.getCommunityId();
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id", communityId);
        try {
            Community community = communityMapper.selectOne(wrapper);
            repair.setCommunityId(community.getLocationName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换报修的状态
     *
     * @param repair
     */
    public void parseState(Repair repair) {
        String stateId = repair.getState();
        QueryWrapper<RepairState> wrapper = new QueryWrapper<>();
        wrapper.eq("status_cd", stateId)
                .eq("table_name", "r_repair_pool")
                .eq("table_columns", "state");
        RepairState stateName = repairStateMapper.selectOne(wrapper);
        repair.setState(stateName.getName());
    }

    /**
     * 转换报修的类型名称
     *
     * @param repair
     */
    public void parseRepairTypeName(Repair repair) {
        String type = repair.getRepairType();
        QueryWrapper<RepairTypeName> wrapper = new QueryWrapper<>();
        try {
            wrapper.eq("repair_type", type);
            RepairTypeName repairTypeName = repairTypeNameMapper.selectOne(wrapper);
            repair.setRepairType(repairTypeName.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回所有报修状态
     *
     * @return
     */
    @Override
    public List<String> listAllRepairState() {
        QueryWrapper<RepairState> wrapper = new QueryWrapper<>();
        wrapper.eq("table_columns", "state")
                .eq("table_name", "r_repair_pool");
        List<RepairState> list = repairStateMapper.selectList(wrapper);
        List<String> listStr = new ArrayList<>();
        for (RepairState state : list) {
            listStr.add(state.getName());
        }
        return listStr;
    }

    /**
     * 返回所有报修类型
     *
     * @return
     */
    @Override
    public List<String> listAllRepairType() {
        QueryWrapper<RepairType> wrapper = new QueryWrapper<>();
        wrapper.eq("table_columns", "repair_type");
        List<RepairType> list = repairTypeMapper.selectList(wrapper);
        List<String> listStr = new ArrayList<>();
        for (RepairType type : list) {
            listStr.add(type.getName());
        }
        return listStr;
    }

    /**
     * 根据id查询工单详细信息
     *
     * @param id
     * @return
     */
    @Override
    public RepairDetailVO getById(String id) {
        RepairDetailVO repairDetailVO = new RepairDetailVO();
        QueryWrapper<RepairDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("repair_id", id);
        RepairDetail repairDetail = repairDetailMapper.selectOne(wrapper);

        parseRepairTypeName(repairDetail);
        parseCommunity(repairDetail);
        parseState(repairDetail);

        //设置参数
        repairDetailVO.setId(repairDetail.getRepairId());
        repairDetailVO.setRepairType(repairDetail.getRepairType());
        repairDetailVO.setRepairName(repairDetail.getRepairName());
        repairDetailVO.setTel(repairDetail.getTel());
        repairDetailVO.setCommunity(repairDetail.getCommunityId());
        repairDetailVO.setAppointmentTime(repairDetail.getAppointmentTime());
        repairDetailVO.setState(repairDetail.getState());
        repairDetailVO.setRepairDescription(repairDetail.getContext());
        //
        RevisitContext revisitContext = parseRevisitContext(repairDetail.getRepairId());
        if (revisitContext != null) {
            repairDetailVO.setVisitContext(revisitContext.getContext());
            System.out.println(revisitContext.getVisitType());
            if (revisitContext.getVisitType().equals("1001")) {
                repairDetailVO.setVisitType("满意");
            } else if (revisitContext.getVisitType().equals("2002")) {
                repairDetailVO.setVisitType("不满意");
            }else {
                repairDetailVO.setVisitType("");
            }
        } else {
            repairDetailVO.setVisitContext("");
            repairDetailVO.setVisitType("");
        }

        return repairDetailVO;
    }

    /**
     * 查询订单回访信息
     */
    public RevisitContext parseRevisitContext(String repairId) {
        QueryWrapper<RevisitContext> wrapper = new QueryWrapper<>();
        wrapper.eq("repair_id", repairId);
        RevisitContext revisitContext = revisitContextMapper.selectOne(wrapper);
        return revisitContext;
    }
}
