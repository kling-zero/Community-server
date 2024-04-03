package com.zeroone.star.project.community.myCommunity;

import com.zeroone.star.project.dto.community.myCommunity.MyCommunityDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.myCommunity.MyCommunityVO;


/**
 * @Description 我的小区查询api
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

public interface MyCommunityApis {

    /**
     * 我的小区分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<MyCommunityVO>> queryAll(int condition);

    JsonVO<PageVO<MyCommunityVO>> updataDate(MyCommunityDTO condition);

}
