package com.zeroone.star.project.homepage;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.homepage.*;
import java.util.List;

/**
 * @Description 首页API定义
 * @Author j3小组-黑夜
 */
public interface HomePageApis {

    /**
     * 获取主页-小区信息
     * @return 主页-小区信息里展示的6个信息
     */
    JsonVO<CommunityVO> getCommunityInfo(String communityId);

    /**
     * 获取主页-小区公告
     * @return 小区公告集合
     */
    JsonVO<List<NoticeVO>> getBulletin(String communityId);

    /**
     * 获取主页-报修统计
     * @return 报修统计
     */
    JsonVO<RepairCountVO> getRepairCount(String communityId);

    /**
     * 获取主页-投诉统计
     * @return 投诉统计
     */
    JsonVO<ComplaintCountVO> getComplaintCount(String communityId);

    /**
     * 获取主页-住户注册统计
     * @return 住户注册统计
     */
    JsonVO<RegisterCountVO> getRegisterCount(String communityId);
}
