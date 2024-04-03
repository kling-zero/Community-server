package com.zeroone.star.schp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.homepage.NoticeVO;
import com.zeroone.star.schp.entity.NNotice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anmux
 * @since 2022-10-18
 */
public interface INNoticeService extends IService<NNotice> {

    List<NoticeVO> getBulletin(String communityId);
}
