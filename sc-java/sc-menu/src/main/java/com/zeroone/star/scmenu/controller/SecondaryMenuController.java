package com.zeroone.star.scmenu.controller;


import com.zeroone.star.project.dto.menu.SecondaryMenuDTO;
import com.zeroone.star.project.menu.SecondaryMenuApis;
import com.zeroone.star.project.query.menu.SecondaryMenuQuery;
import com.zeroone.star.project.utils.redis.RedisUtils;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.menu.SecondaryMenuVO;
import com.zeroone.star.scmenu.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author juanxincai
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/secondarymenu")
@Api(tags = "二级菜单")
@Slf4j
public class SecondaryMenuController implements SecondaryMenuApis {


    @Autowired
    private IMenuService MenuService;

    @ApiOperation("显示二级菜单列表")
    @Override
    @GetMapping("/list")
    public JsonVO<List<SecondaryMenuVO>> selectSubmenu(SecondaryMenuQuery query) {
        List<SecondaryMenuVO> secondaryMenuVOList = MenuService.selectSubmenu(query);
        return JsonVO.success(secondaryMenuVOList);
    }

    @ApiOperation("配置菜单")
    @Override
    @PostMapping("/save")
    public JsonVO<String> saveSubmenu(@RequestBody SecondaryMenuDTO secondaryMenuDTO) {
        boolean save = MenuService.saveSubmenu(secondaryMenuDTO);
        return save ? JsonVO.success("添加成功") : JsonVO.fail("添加失败");
    }

    /**
     * secondaryMenuDTO里没有菜单id，需要再传个参数--菜单id
     * @param secondaryMenuDTO
     * @param secondaryMenuId
     * @return
     */
    @ApiModelProperty("修改菜单信息")
    @PostMapping("/post")
    @Override
    public JsonVO<SecondaryMenuVO> updateSubmenu(@RequestBody SecondaryMenuDTO secondaryMenuDTO, @RequestParam Integer secondaryMenuId) throws Exception {
        if(StringUtils.isEmpty(secondaryMenuId)){
            throw new Exception("菜单Id不能为空");
        }
        SecondaryMenuVO secondaryMenuVO = MenuService.updateSubmenu(secondaryMenuDTO, secondaryMenuId);
        return JsonVO.success(secondaryMenuVO);
    }

    @ApiModelProperty("删除菜单信息")
    @PostMapping("/delete")
    @Override
    public JsonVO<String> deleteSubmenu(@RequestParam Integer Id, @RequestParam String roleName) {
        boolean deleteSubmenu = MenuService.deleteSubmenu(Id, roleName);
        return deleteSubmenu? JsonVO.success("删除成功"):JsonVO.fail("删除失败");
    }

}

