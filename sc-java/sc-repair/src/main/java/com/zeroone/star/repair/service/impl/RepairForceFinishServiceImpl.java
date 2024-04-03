package com.zeroone.star.repair.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.repair.ForceFinishDTO;
import com.zeroone.star.project.query.repair.demoquery.ForceFinishQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.ForceFinishVO;
import com.zeroone.star.repair.entity.RepairPool;
import com.zeroone.star.repair.mapper.RepairPoolMapper;
import com.zeroone.star.repair.service.IRepairForceFinishService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OvO
 * @since 2022-10-18
 */
@Service
public class RepairForceFinishServiceImpl extends ServiceImpl<RepairPoolMapper, RepairPool> implements IRepairForceFinishService {

    @Override
    public PageVO<ForceFinishVO> listAll(ForceFinishQuery query) {
        //构建分页对象
        Page<RepairPool> page = new Page<>(query.getPageIndex(), query.getPageSize());
        //构建条件对象
        QueryWrapper<RepairPool> wrapper = new QueryWrapper<>();
        wrapper.like("repair_name", query.getRepairName());
        //执行分页查询
        Page<RepairPool> pages = baseMapper.selectPage(page, wrapper);
        return PageVO.create(pages, ForceFinishVO.class);
    }

    @Override
    public ForceFinishVO forceFinish(ForceFinishDTO finishDTO) {

        return null;
    }


    @Override
    public ForceFinishVO getDetail(ForceFinishDTO finishDTO) {
        int id = Integer.parseInt(finishDTO.getRepairId());
        ForceFinishVO forceFinishVO = getById(id);
        return forceFinishVO;
    }

    @Override
    public ForceFinishVO getById(int id) {
        RepairPool repair = baseMapper.selectById(id);
        if (repair != null) {
            ForceFinishVO vo = new ForceFinishVO();
            BeanUtil.copyProperties(repair, vo);
            return vo;
        }
        return null;
    }
}
