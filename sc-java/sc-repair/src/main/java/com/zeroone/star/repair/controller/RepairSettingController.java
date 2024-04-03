package com.zeroone.star.repair.controller;

import com.zeroone.star.project.dto.repair.repairsetting.RepairSettingDTO;
import com.zeroone.star.project.query.repair.repairsetting.RepairSettingQuery;
import com.zeroone.star.project.repair.RepairSettingApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.repairsetting.RepairSettingVO;
import com.zeroone.star.repair.service.RRepairSettingService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 报修设置
 *
 * @author iceberg-work
 */
@RestController
@RequestMapping("/RepairSetting")
@Slf4j
public class RepairSettingController implements RepairSettingApis {

    @Resource
    RRepairSettingService service;

    @Override
    @PostMapping("/list")
    @ApiOperation("查询多条报修设置")
    @ResponseBody
    public JsonVO<PageVO<RepairSettingVO>> listRepairSetting(@Valid RepairSettingQuery query) {
        return service.listRepairSetting(query);
    }

    @Override
    @ApiOperation("修改单条报修设置")
    @ResponseBody
    @PostMapping("/update")
    public JsonVO<RepairSettingVO> updateRepairSetting(@Valid RepairSettingDTO dto) throws Exception {
        return service.updateRepairSetting(dto);
    }

    @Override
    @ApiOperation("新增单条报修设置")
    @ResponseBody
    @PostMapping("/add")
    public JsonVO<RepairSettingVO> addRepairSetting(@Valid RepairSettingDTO dto) throws Exception {
        return service.addRepairSetting(dto);
    }

    @Override
    @ApiOperation("删除单条报修设置")
    @ResponseBody
    @PostMapping("/delete")
    public JsonVO<RepairSettingVO> deleteRepairSetting(@Valid RepairSettingDTO dto) throws Exception {
        return service.deleteRepairSetting(dto);
    }
}
