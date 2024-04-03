package com.zeroone.star.sccommonmenu.controller;



import com.alibaba.cloud.commons.lang.StringUtils;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;
import com.zeroone.star.sccommonmenu.model.BaseContext;
import com.zeroone.star.sccommonmenu.model.constant.CommonMenuConstant;
import com.zeroone.star.sccommonmenu.model.redisMtehods.RedisUtils;
import com.zeroone.star.sccommonmenu.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/sc-common-menu")
@Api(tags = "菜单接口")
@Slf4j
public class MenuController {
    @Autowired
    private IMenuService menuService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("获得菜单目录")
    @GetMapping("/menuList")
    public JsonVO<List<TreeMenuVO>> menuList(){

        String userId = BaseContext.getCurrentId();
        String redisKey = CommonMenuConstant.MENU_KEY + userId;

        //从redis获得缓存
        List<TreeMenuVO> redsTreeMenuVOList = redisUtils.getList(redisKey, CommonMenuConstant.TREE_MENU_VO);
        if(redsTreeMenuVOList != null && redsTreeMenuVOList.size() > 0){
            log.info("菜单列表:从redis获得缓存成功");
            return JsonVO.success(redsTreeMenuVOList);
        }

        //从mysql中查询
        List<TreeMenuVO> treeMenuVOList = menuService.treeMenuVOList();
        if(treeMenuVOList.size() > 0){
            boolean b = redisUtils.ListIntoRedisWithTimeLimit(redisKey, treeMenuVOList, 60 * 24 * 3);
            log.info("菜单列表:redis添加缓存" + b);
        }

        return JsonVO.success(treeMenuVOList);
    }
}

