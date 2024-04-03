package com.zeroone.star.repair.controller;


import com.zeroone.star.project.dto.repair.ForceFinishDTO;
import com.zeroone.star.project.query.repair.demoquery.ForceFinishQuery;
import com.zeroone.star.project.repair.ForceFinishApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.ForceFinishVO;
import com.zeroone.star.repair.service.IRepairForceFinishService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OvO
 * @since 2022-10-18
 */
@RestController
@RequestMapping("/repair/r-repair-forceFinish")
public class RepairForceFinishController implements ForceFinishApi {

    IRepairForceFinishService service;

    @GetMapping("query-all")
    @ApiOperation("查询所有")
    @Override
    public JsonVO<PageVO<ForceFinishVO>> queryAll(ForceFinishQuery condition) {
        return JsonVO.success(service.listAll(condition));
    }


    @PostMapping("forceFinish")
    @ApiOperation("强制回单")
    @Override
    public JsonVO<ForceFinishVO> forceFinish(ForceFinishDTO finishDTO) {
        return JsonVO.success(service.forceFinish(finishDTO));
    }


    @GetMapping("getDetail")
    @ApiOperation("详细")
    @Override
    public JsonVO<ForceFinishVO> detail(ForceFinishDTO finishDTO) {
        return JsonVO.success(service.getDetail(finishDTO));
    }

}

