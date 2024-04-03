package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.propertyrightregistration.CheckDTO;
import com.zeroone.star.project.vo.community.propertyrightregistration.CheckVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.Check;
import com.zeroone.star.sccommunity.mapper.prrmanagement.CheckMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.ICheckService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CheckImpl extends ServiceImpl<CheckMapper, Check> implements ICheckService {
    @Autowired
    ICheckService service;

    @Autowired
    CheckMapper mapper;
    @Override
    public CheckVO checkDTO(CheckDTO condition) {
        CheckVO checkVO = new CheckVO();
        QueryWrapper<Check> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("prr_id", condition.getPrrId());
        wrapper1.eq("create_time", condition.getCreateTime());
        Check check = mapper.selectOne(wrapper1);
        UpdateWrapper<Check> wrapper = new UpdateWrapper<>();
        wrapper.eq("prr_id", condition.getPrrId());
        wrapper.eq("room_id", condition.getRoomId());

        String state = condition.getState();
        if (state.equals("未审核")){
            check.setState("0");
        }else if(state.equals("审核未通过")){
            check.setState("2");
        }else{
            check.setState("1");
        }
        check.setRemark(condition.getRemark());
        service.update(check, wrapper);
        BeanUtils.copyProperties(check, checkVO);
        String checkState = check.getState();
        if(checkState.equals("1")){
            checkVO.setState("审核通过");
        }else if(checkState.equals("2")){
            checkVO.setState("审核未通过");
        }
        return checkVO;
    }
}
