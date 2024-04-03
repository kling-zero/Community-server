package com.zeroone.star.project.communityConfig;

import com.zeroone.star.project.dto.CommunityConfigDTO;
import com.zeroone.star.project.query.CommunityConfigQuery;
import com.zeroone.star.project.vo.CommunityConfigVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;


/**
 * @date 2022-10-16 - 4:41
 * @Description 获取cpp模块接口定义
 * @author Colins
 */
public interface CommunityConfigApis {
    /**
     * 获取小区设置信息
     * @return 查询结果
     */
    JsonVO<PageVO<CommunityConfigVO>> queryConfig(CommunityConfigQuery query);

    /**
     * 新增小区配置
     * @return 新增是否成功
     */
    JsonVO<Boolean> addConfig(CommunityConfigDTO communityConfig);
}
