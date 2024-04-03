package com.zeroone.star.sccommunity.controller.community.roomrenovation;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.community.roomRenovation.RoomRenovationApis;

import com.zeroone.star.project.dto.community.roomRenovation.RoomBasicDTO;

import com.zeroone.star.project.query.community.roomRenovation.BasicRenovationQuery;
import com.zeroone.star.project.query.community.roomRenovation.DetailRenovationQuery;
import com.zeroone.star.project.query.community.roomRenovation.RecordRenovationQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.BasicRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.DetailRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.RecordRenovationVO;
import com.zeroone.star.sccommunity.service.roomrenovation.RoomBasicService;
import com.zeroone.star.sccommunity.service.roomrenovation.impl.RoomBasicServiceImpl;
import com.zeroone.star.sccommunity.service.roomrenovation.impl.RoomDetailServiceImpl;
import com.zeroone.star.sccommunity.service.roomrenovation.impl.RoomRecordServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/roomRenovation")
@Api(tags = "房屋装修")
@Validated
public class RoomRenovationController implements RoomRenovationApis {

    @Resource
    private RoomDetailServiceImpl roomDetailService;

    @Resource
    private RoomBasicServiceImpl roomBasicService;
    @Resource
    private RoomRecordServiceImpl roomRecordService;
    @GetMapping("/query-allBasic")
    @ApiOperation(value = "查询所有房屋基本信息")
    @Override
    public JsonVO<PageVO<BasicRenovationVO>> queryAll(BasicRenovationQuery condition) {
        PageVO<BasicRenovationVO> list=roomBasicService.queryAll(condition);
        return JsonVO.success(list);
    }
    @PostMapping("/update-Basic")
    @ApiOperation(value = "修改房屋基本信息")
    @Override
    public JsonVO<String> updateBasic(RoomBasicDTO condition) {
        roomBasicService.updateBasic(condition);
        return JsonVO.success("修改成功");
    }
    @PostMapping("/add-Basic")
    @ApiOperation(value = "添加房屋基本信息")
    @Override
    public JsonVO<String> saveBasic(RoomBasicDTO condition) {
        roomBasicService.saveBasic(condition);
        return JsonVO.success("添加成功");
    }
    @PostMapping("/delete-Basic")
    @ApiOperation(value = "删除房屋基本信息")
    @Override
    public JsonVO<String> deleteBasic(RoomBasicDTO condition) {
        roomBasicService.deleteBasic(condition);
        return JsonVO.success("删除成功");
    }

    @Override
    public JsonVO<BasicRenovationVO> queryId(int id) {
        return null;
    }
    @GetMapping("/query-allDetail")
    @ApiOperation(value = "查询所有房屋验收明细信息")
    @Override
    public JsonVO<PageVO<DetailRenovationVO>> queryDetailAllById(DetailRenovationQuery condition) {
        PageVO<DetailRenovationVO> list=roomDetailService.queryDetailAllById(condition);
        return JsonVO.success(list);
    }
    @GetMapping("/query-allRecord")
    @ApiOperation(value = "查询所有房屋追踪信息")
    @Override
    public JsonVO<PageVO<RecordRenovationVO>> queryRecordAllById(RecordRenovationQuery condition) {
        PageVO<RecordRenovationVO> list=  roomRecordService.queryRecordAllById(condition);
        return JsonVO.success(list);
    }
    @PostMapping("/delete-allRecord")
    @ApiOperation(value = "删除房屋追踪记录")
    @Override
    public JsonVO<String> deleteRecord(RecordRenovationQuery condition) {
        roomRecordService.deleteRecord(condition);
        return JsonVO.success("删除成功");
    }
    @PostMapping("/query-allRecordDetail")
    @ApiOperation(value = "查询房屋追踪记录详情")
    @Override
    public JsonVO<PageVO<RecordRenovationVO>> queryRecordDetail(RecordRenovationQuery condition) {
        PageVO<RecordRenovationVO> list=  roomRecordService.queryRecordAllById(condition);
        return JsonVO.success(list);
    }






}
