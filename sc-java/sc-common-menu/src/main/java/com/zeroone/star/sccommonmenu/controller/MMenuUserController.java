package com.zeroone.star.sccommonmenu.controller;


import com.alibaba.cloud.commons.lang.StringUtils;
import com.nimbusds.jose.util.IntegerUtils;
import com.zeroone.star.project.dto.commonMenu.MMenuUserDTO;
import com.zeroone.star.project.query.commonMenu.MMenuUserQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.commonMenu.MMenuUserVO;
import com.zeroone.star.sccommonmenu.model.BaseContext;
import com.zeroone.star.sccommonmenu.model.constant.CommonMenuConstant;
import com.zeroone.star.sccommonmenu.model.exception.MenuUserException;
import com.zeroone.star.sccommonmenu.model.redisMtehods.RedisUtils;
import com.zeroone.star.sccommonmenu.service.impl.MMenuUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/sc-common-menu")
@Api(tags = "常用菜单")
@Slf4j
public class MMenuUserController {
    @Autowired
    private MMenuUserServiceImpl mMenuUserService;

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("分页查询常用菜单")
        @GetMapping("/listMenuUser")
    public JsonVO<List<MMenuUserVO>> listMenuUser(@Validated MMenuUserQuery mMenuUserQuery){//, @RequestParam("hasCondition") String hasCondition) {
        String userId = BaseContext.getCurrentId();
        String Rediskey = CommonMenuConstant.MENU_USER_KEY + userId;

        //从redis获得缓存
        //基于reids完成分页操作
            long start = (mMenuUserQuery.getPageIndex() - 1) * mMenuUserQuery.getPageSize();
            long end = start + mMenuUserQuery.getPageSize();
        List<MMenuUserVO> menuUserlist = redisUtils.getList(Rediskey, CommonMenuConstant.M_MENU_USER_VO, start, end);

        if (menuUserlist != null && menuUserlist.size() > 0) {
            log.info("常用菜单:从redis获得缓存成功");
            //条件过滤
            if (!StringUtils.isEmpty(mMenuUserQuery.getMuId())) {
                String finalMuId = mMenuUserQuery.getMuId();
                menuUserlist = menuUserlist.stream().filter(item -> {
                    return item.getMuId().equals(finalMuId);
                }).collect(Collectors.toList());
            }
            if (!StringUtils.isEmpty(mMenuUserQuery.getName())) {
                String finalName = mMenuUserQuery.getName();
                menuUserlist = menuUserlist.stream().filter(item -> {
                    return item.getName().equals(finalName);
                }).collect(Collectors.toList());
            }
            if (mMenuUserQuery.getSeq() != null) {
                Integer finalSeq = mMenuUserQuery.getSeq();
                menuUserlist = menuUserlist.stream().filter(item -> {
                    return item.getSeq().equals(finalSeq);
                }).collect(Collectors.toList());
            }
            return JsonVO.success(menuUserlist);
        }

        //reids没有缓存，从mysql查询
        List<MMenuUserVO> result = mMenuUserService.listMenuUser(mMenuUserQuery, userId);
        //分页操作
        List<MMenuUserVO> pageResult = result.subList((int) start, (int) Math.min(end, result.size()));
        if (result != null && result.size() > 0 ) {
            //添加缓存
            boolean b = redisUtils.ListIntoRedisWithTimeLimit(Rediskey, result, 60 * 24 * 3);//三天
            log.info("常用菜单:redis添加缓存" + b);
        }
        return JsonVO.success(pageResult);
    }

    /**
     * 实际是将 m_menu_user 表的 StatusCd字段 改成 1
     *
     * @param mMenuUserDTO
     * @return
     */
    @ApiOperation("删除常用菜单(实际是将 m_menu_user 表的 StatusCd字段 改成 1)")
    @DeleteMapping("/deleteMenuUser")
    public JsonVO<String> deleteMenuUser(@RequestBody MMenuUserDTO mMenuUserDTO) {
        log.info(mMenuUserDTO.toString());
        String userId = BaseContext.getCurrentId();
        mMenuUserDTO.setStaffId(userId);

        String rediskey = CommonMenuConstant.MENU_USER_KEY + userId;

        String muId = mMenuUserDTO.getMuId();
        if (StringUtils.isEmpty(muId)) {
            throw new MenuUserException("删除常用菜单时,常用菜单ID不能为空");
        }
        Boolean deleteMenuUserRes = mMenuUserService.deleteMenuUser(mMenuUserDTO);

        return deleteMenuUserRes ? JsonVO.success("删除成功") : JsonVO.fail("删除失败");
    }

    @ApiOperation("添加常用菜单")
    @PostMapping("/saveMenuUser")
    public JsonVO<String> saveMenuUser(@RequestBody MMenuUserDTO mMenuUserDTO) {
        log.info(mMenuUserDTO.toString());
        String userId = BaseContext.getCurrentId();
        mMenuUserDTO.setStaffId(userId);

        String rediskey = CommonMenuConstant.MENU_USER_KEY + userId;

        String mId = mMenuUserDTO.getMId();
        if (StringUtils.isEmpty(mId)) {
            throw new MenuUserException("添加常用菜单时,菜单ID不能为空");
        }
        Boolean saveMenuUserRes = mMenuUserService.saveMenuUser(mMenuUserDTO);

        return saveMenuUserRes ? JsonVO.success("添加成功") : JsonVO.fail("添加失败");
    }
}

