package com.zeroone.star.management.controller;


import com.zeroone.star.management.service.ICityAreaService;
import com.zeroone.star.project.management.CityAreaApi;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.management.CityAreaVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2022-10-23
 */
@RestController
@RequestMapping("/management/city-area")
@Api(tags = "城市列表")
public class CityAreaController implements CityAreaApi {

    @Autowired
    ICityAreaService cityAreaService;

    @GetMapping("get-areas")
    @ApiOperation(value = "获取城市列表")
    @Override
    public JsonVO<List<CityAreaVO>> getAreas(CityAreaQuery cityAreaQuery) {
        if (cityAreaQuery.getAreaLevel()==null || cityAreaQuery.getParentAreaNode()==null){
            return JsonVO.fail(null);
        }
        List<CityAreaVO> areas = cityAreaService.getAreas(cityAreaQuery);
        System.out.println(areas);
        return JsonVO.success(areas);
    }

}



