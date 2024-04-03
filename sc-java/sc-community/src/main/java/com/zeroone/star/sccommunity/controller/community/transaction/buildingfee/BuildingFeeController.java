package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.project.dto.community.transactions.buildingfee.*;
import com.zeroone.star.project.query.community.transactions.buildingfee.BuildingFeesQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.FeeConfigsQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.MRQDataQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.MeterReadingQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.*;
import com.zeroone.star.sccommunity.entity.buildingfee.MeterWater;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFee;
import com.zeroone.star.sccommunity.entity.buildingfee.PayFeeConfig;
import com.zeroone.star.sccommunity.entity.buildingfee.TDict;
import com.zeroone.star.sccommunity.service.buildingfee.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sccommunity/community/transactions/building-fee")
@Api(tags = "房屋费用")
@Validated
@Slf4j
public class BuildingFeeController {

    @Autowired
    private IMeterTypeService meterTypeService;
    @Autowired
    private IMeterWaterService meterWaterService;
    @Resource
    private IPayFeeService payFeeService;
    @Resource
    private IPayFeeConfigService payFeeConfigService;

    @GetMapping("/query-all")
    @ApiOperation(value = "查询房屋费用")
    public JsonVO<PageVO<FeesVO>> queryAll(BuildingFeesQuery condition){
        return JsonVO.success(payFeeService.queryPayFee(condition));
    }

    @GetMapping("/query-configId")
    @ApiOperation(value = "根据费用类型查询费用项目")
    @ResponseBody
    public JsonVO<List<FeeConfigsVO>> queryConfigId(FeeConfigsQuery condition){
        return JsonVO.success(payFeeConfigService.listFeeConfigs(condition));
    }

    @PostMapping("/add-temp-fee")
    @ApiOperation(value = "临时收费接口")
    public JsonVO<String> addTempFee(TempFeeDTO dto){
        payFeeService.saveTempFee(dto);
        return JsonVO.success("新增临时收费成功");
    }

    @GetMapping("/query-obj")
    @ApiOperation(value = "根据抄表类型查询数据对象接口")
    public JsonVO<PageVO<MRQDataVO>> queryObj(MRQDataQuery condition){
        PageVO<MRQDataVO> mrqDataVO = meterWaterService.getLastInfo(condition);
        return JsonVO.success(mrqDataVO);
    }

    @GetMapping("/query-meter-reading")
    @ApiOperation(value = "查询抄表类型接口")
    public JsonVO<PageVO<MeterTypesVO>> queryMeterReading(MeterReadingQuery condition){
        PageVO<MeterTypesVO> types = meterTypeService.queryAll(condition);
        return JsonVO.success(types);
    }

    @PostMapping("/add-we-meter-reading")
    @ApiOperation(value = "提交水电抄表接口")
    public JsonVO<String> addWEMeterReading(WEMeterReadingDTO dto){
        MeterWater meterWater = new MeterWater();
        PayFee payFee = new PayFee();
        BeanUtils.copyProperties(dto, meterWater);
        BeanUtils.copyProperties(dto, payFee);
        meterWaterService.save(meterWater);
        payFeeService.save(payFee);
        return JsonVO.success("添加成功");
    }

    @PostMapping("/add-fee")
    @ApiOperation(value = "提交创建费用接口")
    public JsonVO<String> addFee(FeeDTO dto){
        PayFee payFee = new PayFee();
        BeanUtils.copyProperties(dto, payFee);
        payFeeService.save(payFee);
        return JsonVO.success("添加成功");
    }

    @PostMapping("/remove-fee-by-id")
    @ApiOperation(value = "取消费用接口")
    public JsonVO<String> removeFeeById(FeeIdDTO dto){
        //判断结束费用是否缴费过，如果缴费过，需要先退费才行，返回失败结果
        PayFee payFee = payFeeService.getById(dto.getFeeId());
        if (payFee.getState().equals("2009001")){
            return JsonVO.fail("费用删除失败，请先将费用退回再删除");
        }
        //判断费用id是否为空
        if (dto.getFeeId() != null && dto.getCommunityId() != null) {
            PayFee fee = payFeeService.getById(dto.getFeeId());
            if (fee.getCommunityId().equals(dto.getCommunityId())) {
                payFeeService.removeById(dto.getFeeId());
            }
        }
        return JsonVO.success("取消费用成功");
    }


    @PostMapping("/finish-fee-by-id")
    @ApiOperation(value = "手工结束接口")
    public JsonVO<String> finishFeeById(FeeIdDTO dto){
        //判断费用id是否为空
        if (dto.getFeeId() != null && dto.getCommunityId() != null) {
            PayFee payFee = payFeeService.getById(dto.getFeeId());
            if (payFee.getCommunityId().equals(dto.getCommunityId())) {
                payFeeService.removeById(dto.getFeeId());
                return JsonVO.success("结束费用成功");
            }
        }
        return JsonVO.fail("手工结束费用失败");
    }
}
