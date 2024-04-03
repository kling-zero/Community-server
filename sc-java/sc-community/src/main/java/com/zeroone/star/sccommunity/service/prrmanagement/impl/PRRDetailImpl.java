package com.zeroone.star.sccommunity.service.prrmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRRDetail;
import com.zeroone.star.sccommunity.mapper.prrmanagement.PRRDetailMapper;
import com.zeroone.star.sccommunity.service.prrmanagement.IPRRDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class PRRDetailImpl extends ServiceImpl<PRRDetailMapper, PRRDetail> implements IPRRDetailService {

    @Autowired
    PRRDetailMapper mapper;

    @Autowired
    IPRRDetailService service;

    @Override
    public PageVO<PRRDetailVO> queryDetailById(PRRDetailQuery condition){

        Page<PRRDetail> page = new Page<>(condition.getPageIndex(),condition.getPageSize());

//        PRRDetailVO prrDetailVO = new PRRDetailVO();
        LambdaQueryWrapper<PRRDetail> wrapper = new LambdaQueryWrapper<>();
        String prrdId = condition.getPrrdId();
        wrapper.eq(!StringUtils.isEmpty(prrdId), PRRDetail::getPrrdId,prrdId);
        PRRDetail prrDetail = mapper.selectOne(wrapper);
//        PRRDetail prrDetail = mapper.selectOne(condition.getPrrId());
        if (prrDetail!=null){
            PRRDetailVO vo = new PRRDetailVO();
//            BeanUtils.copyProperties(prrDetail, vo);
            vo.setPrrdId(prrDetail.getPrrdId());
            vo.setPrrId(prrDetail.getPrrId());
            vo.setCreateTime(prrDetail.getCreateTime());
//            vo.setSecurities(prrDetail.getSecurities());
            String securities = prrDetail.getSecurities();
            vo.setSecurities(securities=="001"?"身份证":securities=="002"?"购房合同":securities=="003"?"维修基金":securities=="004"?"契税":"001");

//            vo.setIsTrue(prrDetail.getIsTrue());
            String isTrue = prrDetail.getIsTrue();
            vo.setIsTrue(isTrue=="true"?"是":"否");
            vo.setCreateUser(prrDetail.getCreateUser());
            vo.setStatusCd(prrDetail.getStatusCd());

            return PageVO.create(page, PRRDetailVO.class);
        }else{
            return  null;
        }
//

    }
}
