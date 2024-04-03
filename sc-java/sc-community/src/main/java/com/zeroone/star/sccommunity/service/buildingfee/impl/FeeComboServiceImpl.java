package com.zeroone.star.sccommunity.service.buildingfee.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.community.transactions.buildingfee.FeeComboDTO;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboMemberByComboIdQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feecombo.FeeComboQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboMemberVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feecombo.FeeComboVO;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeCombo;
import com.zeroone.star.sccommunity.entity.buildingfee.FeeComboMember;
import com.zeroone.star.sccommunity.mapper.buildingfee.FeeComboMapper;
import com.zeroone.star.sccommunity.mapper.buildingfee.FeeComboMemberMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeComboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2022-10-23
 */
@Service
public class FeeComboServiceImpl extends ServiceImpl<FeeComboMapper, FeeCombo> implements IFeeComboService {

    @Autowired
    FeeComboMemberMapper feeComboMemberMapper;
    @Override
    public PageVO<FeeComboVO> listAll(FeeComboQuery query) {
        // 构建分页对象
        Page<FeeCombo> page = new Page<>(query.getPageIndex(), query.getPageSize());
        // 构建条件对象
        QueryWrapper<FeeCombo> wrapper = new QueryWrapper<>();
        wrapper.like("combo_name", query.getComboName())
                .like("community_id",query.getCommunityId());
        // 执行分页查询
        Page<FeeCombo> feeComboPage = baseMapper.selectPage(page, wrapper);
        return PageVO.create(feeComboPage, FeeComboVO.class);
    }

    @Override
    public PageVO<FeeComboMemberVO> getById(FeeComboMemberByComboIdQuery query) {
        // 构建分页对象
        Page<FeeCombo> page = new Page<>(query.getPageIndex(), query.getPageSize());
        // 构建条件对象
        QueryWrapper<FeeCombo> wrapper = new QueryWrapper<>();
        wrapper.like("combo_id",query.getComboId());
        // 执行分页查询
        Page<FeeCombo> feeComboPage = baseMapper.selectPage(page, wrapper);
        return PageVO.create(feeComboPage, FeeComboMemberVO.class);
    }

    @Override
    @Transactional
    public int insert(FeeComboDTO feeComboDTO) {
        String comboId = IdWorker.getIdStr();
        String memberId = IdWorker.getIdStr();
        LocalDateTime time = LocalDateTime.now();

        // 费用套餐表 fee_combo
        FeeCombo feeCombo = new FeeCombo();
        feeCombo.setComboId(comboId);
        feeCombo.setComboName(feeComboDTO.getComboName());
        feeCombo.setCommunityId(feeComboDTO.getCommunityId());
//        feeCombo.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        feeCombo.setCreateTime(time);
        feeCombo.setStatusCd("0");
        feeCombo.setRemark(feeComboDTO.getRemark());
        int feeComboResult = baseMapper.insert(feeCombo);

        // 费用套餐成员表 fee_combo_member
        FeeComboMember feeComboMember = new FeeComboMember();
        feeComboMember.setMemberId(memberId);
        feeComboMember.setComboId(comboId);
        feeComboMember.setConfigId(feeComboDTO.getFeeComboMember().get(0).getConfigId());
        feeComboMember.setCommunityId(feeComboDTO.getCommunityId());
        feeComboMember.setCreateTime(time);
        feeCombo.setStatusCd("0");
        int feeComboMemberResult = feeComboMemberMapper.insert(feeComboMember);

        return feeComboResult + feeComboMemberResult;
    }
}
