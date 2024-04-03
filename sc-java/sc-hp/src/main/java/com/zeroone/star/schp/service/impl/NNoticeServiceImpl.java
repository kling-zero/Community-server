package com.zeroone.star.schp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.vo.homepage.NoticeVO;
import com.zeroone.star.schp.entity.NNotice;
import com.zeroone.star.schp.mapper.NNoticeMapper;
import com.zeroone.star.schp.service.INNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anmux
 * @since 2022-10-18
 */
@Service
public class NNoticeServiceImpl extends ServiceImpl<NNoticeMapper, NNotice> implements INNoticeService {


    @Override
    public List<NoticeVO> getBulletin(String communityId) {

        //查询公告
//        List<NNotice> nNoticeList = baseMapper.selectList(null);
//        List<NoticeVO> noticeVOS = new ArrayList<>();
//        BeanUtils.copyProperties(nNoticeList,noticeVOS);
//        return noticeVOS;

        //根据小区id查询公告
        QueryWrapper<NNotice> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",communityId);
        List<NNotice> nNoticeList = baseMapper.selectList(wrapper);

        //创建VO
        List<NoticeVO> noticeVOs = nNoticeList.stream().map((notice) -> {
            NoticeVO noticeVO = new NoticeVO();
            BeanUtils.copyProperties(notice, noticeVO);
            return noticeVO;
        }).collect(Collectors.toList());

        return noticeVOs;

    }
}
