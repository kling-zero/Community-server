package com.zeroone.star.scsetting.controller;

import com.zeroone.star.project.communityConfig.CommunityConfigApis;
import com.zeroone.star.project.dto.CommunityConfigDTO;
import com.zeroone.star.project.query.CommunityConfigQuery;
import com.zeroone.star.project.vo.CommunityConfigVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2022-10-17 - 5:10
 * @Author: Colins
 * @Description: 小区配置
 */
@Controller
@RequestMapping("communityConfig")
@Api(tags = "communityConfig")
public class CommunityConfigController implements CommunityConfigApis {
    @ApiOperation("小区配置查询")
    @PostMapping("communityConfifQuery")
    @Override
    public JsonVO<PageVO<CommunityConfigVO>> queryConfig(CommunityConfigQuery query) {
        return null;
    }

    @ApiOperation("小区配置新增")
    @PostMapping("communityConfifAdd")
    @Override
    public JsonVO<Boolean> addConfig(CommunityConfigDTO communityConfig) {
        return null;
    }
}
