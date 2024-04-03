package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.community.propertyrightregistration.DeletePPRDTO;

import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.DeletePPR;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import com.zeroone.star.sccommunity.mapper.prrmanagement.DeletePPRMapper;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IPRRService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PRRImpl extends ServiceImpl<PRRMapper, PRR> implements IPRRService {

    @Autowired
    IPRRService service;

    @Autowired
    DeletePPRMapper mapper;

    @Override
    public PageVO<PRRVO> queryAll(PRRQuery condition) {
        Page<PRR> page = new Page<>(condition.getPageIndex(),condition.getPageSize());

        Page<PRR> selectPage;
        if(condition==null)//查询全部
        {
            QueryWrapper<PRR> wrapper = new QueryWrapper<>();
            selectPage = service.getBaseMapper().selectPage(page, wrapper);
        }else{
            String address = condition.getAddress();
            String communityId = condition.getCommunityId();
            String idCard = condition.getIdCard();
            String link = condition.getLink();
            String name = condition.getName();
            String roomId = condition.getRoomId();
            String state = condition.getState();
            if (state.equals("未审核")){
                state="0";
            }else if (state.equals("审核通过")){
                state="1";
            }else{
                state="2";
            }

            LambdaQueryWrapper<PRR> wrapper = new LambdaQueryWrapper<>();
            wrapper.like(!StringUtils.isEmpty(address),PRR::getAddress,address);
            wrapper.like(!StringUtils.isEmpty(communityId),PRR::getCommunityId,communityId);
            wrapper.like(!StringUtils.isEmpty(idCard),PRR::getIdCard,idCard);
            wrapper.like(!StringUtils.isEmpty(link),PRR::getLink,link);
            wrapper.like(!StringUtils.isEmpty(name),PRR::getName,name);
            wrapper.like(!StringUtils.isEmpty(roomId),PRR::getRoomId,roomId);
            wrapper.like(!StringUtils.isEmpty(state),PRR::getState,state);

            selectPage = service.getBaseMapper().selectPage(page, wrapper);
        }

        return PageVO.create(selectPage,PRRVO.class);
    }

    @Override
    public int deletePPR(DeletePPRDTO condition) {
        QueryWrapper<DeletePPR> wrapper = new QueryWrapper<>();
        wrapper.eq("prr_id", condition.getPrrId());
        wrapper.eq("create_time", condition.getCreateTime());
        DeletePPR deletePPR = mapper.selectOne(wrapper);
        if (deletePPR!=null){
//            BeanUtils.copyProperties(condition, deletePPR);
            int row = mapper.delete(wrapper);
            return row;
        }
        System.out.println("数据库中没有此字段");
        return 0;
    }


//    @Override
//    public int removeById(long prrId) {
//        QueryWrapper<DeletePPR> wrapper = new QueryWrapper<>();
//        wrapper.eq("prr_id", prrId);
//        DeletePPR deletePPR = mapper.selectOne(wrapper);
//        if (deletePPR!=null) {
//            int row = mapper.deleteById(deletePPR);
//            return row;
//        }
//        else
//            return 0;
//    }


}
