package com.zeroone.star.repair.controller.haddone;


import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.repair.handone.RepairQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.repair.haddone.RepairDetailVO;
import com.zeroone.star.project.vo.repair.haddone.RepairStateVO;
import com.zeroone.star.project.vo.repair.haddone.RepairTypeVO;
import com.zeroone.star.project.vo.repair.haddone.RepairVO;
import com.zeroone.star.repair.entity.haddone.RepairType;
import com.zeroone.star.repair.service.haddone.IRepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
@RequestMapping("repair")
@Api(tags = "repair")
@Validated//支持数据校验
public class RepairController {
    @Autowired
    IRepairService repairService;

    /**
     * 查询所有报修已办的所有数据
     * @param pageQuery
     * @return
     */
    @GetMapping("query-all")
    @ApiOperation(value = "查询所有报修已办(默认状态是办理完成或电话回访表示已办)")
    public JsonVO<PageVO<RepairVO>> queryAll(PageQuery pageQuery){
        return JsonVO.success(repairService.listAll(pageQuery));
    }

    /**
     * 根据筛选条件进行查询
     * @param query
     * @return
     */
    @GetMapping("query-conditions")
    @ApiOperation(value = "根据筛选条件查询")
    public JsonVO<PageVO<RepairVO>> queryByCondition(RepairQuery query){
        return null;
    }

    /**
     * 查询所有的报修状态
     * @return
     */
    @GetMapping("query-state")
    @ApiOperation(value = "查询所有的报修状态")
    public JsonVO<List> queryRepairState(){
        return JsonVO.create(repairService.listAllRepairState(),ResultStatus.SUCCESS);
    }

    /**
     * 查询所有的报修类型
     * @return
     */
    @GetMapping("query-type")
    @ApiOperation(value = "查询所有的报修类型")
    public JsonVO<List> queryRepairType(){
        List<String> list = repairService.listAllRepairType();
        return JsonVO.create(list, ResultStatus.SUCCESS);
    }

    /**
     * 查询某一id的报修单详情
     * @return
     */
    @GetMapping("query-id")
    @ApiOperation(value = "查询某一id的报修单详情")
    public JsonVO<RepairDetailVO> queryById(@RequestParam String id){
        RepairDetailVO repairServiceById = repairService.getById(id);
        return JsonVO.create(repairServiceById,ResultStatus.SUCCESS);
    }
}
