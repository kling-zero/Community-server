package com.zeroone.star.scsetting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.setting.PersonnelDto;
import com.zeroone.star.project.query.setting.PersonnelQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.PersonnelVO;
import com.zeroone.star.scsetting.entity.Personnel;
import com.zeroone.star.scsetting.mapper.PersonnelMapper;
import com.zeroone.star.scsetting.service.PersonnelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author insist
 * @since 2022-10-15
 */
@Service
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, Personnel> implements PersonnelService {


    @Override
    public PageVO<PersonnelVO> queryPersonnelByName(List<String> staffIds, PersonnelQuery personnelQuery) {
        Page<Personnel> page = new Page<>(personnelQuery.getPageIndex(), personnelQuery.getPageSize());
        LambdaQueryWrapper<Personnel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Personnel::getId, staffIds);
        if (personnelQuery.getName() != null) {
            queryWrapper.like(Personnel::getName, personnelQuery.getName());
        }
        Page<Personnel> personnelPage = baseMapper.selectPage(page, queryWrapper);
        return PageVO.create(personnelPage, PersonnelVO.class);
    }

    @Override
    public List<PersonnelVO> queryNotAssociatedPersonnelByName(List<String> staffIds, String name) {
        LambdaQueryWrapper<Personnel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Personnel::getId, staffIds);
        if (name != null) {
            queryWrapper.like(Personnel::getName, name);
        }
        List<Personnel> personnels = baseMapper.selectList(queryWrapper);
        List<PersonnelVO> personnelVOS = personnels.stream().map(personnel -> {
            PersonnelVO personnelVO = new PersonnelVO();
            BeanUtils.copyProperties(personnel, personnelVO);
            return personnelVO;
        }).collect(Collectors.toList());

        return personnelVOS;
    }

    @Override
    public PersonnelDto selectPersonnelById(String PersonnelId) {
        Personnel personnel = baseMapper.selectById(PersonnelId);
        PersonnelDto personnelDto = new PersonnelDto();
        BeanUtils.copyProperties(personnel, personnelDto);
        return personnelDto;
    }
}
