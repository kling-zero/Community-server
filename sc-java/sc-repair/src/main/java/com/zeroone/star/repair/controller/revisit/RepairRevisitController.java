package com.zeroone.star.repair.controller.revisit;

import com.zeroone.star.project.dto.repair.revisit.RepairRevisitDto;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.query.repair.revisit.RepairRevisitQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.haddone.RepairDetailVO;
import com.zeroone.star.project.vo.repair.revisit.RepairRevisitStateVO;
import com.zeroone.star.project.vo.repair.revisit.RepairRevisitVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("repair-revisit")
@Api(tags = "repair-revisit")
@Validated//支持数据校验
public class RepairRevisitController {

    @GetMapping("query-all")
    @ApiOperation("查询所有为回访的报修（默认是未回访的）")
    public JsonVO<PageVO<RepairRevisitVO>> queryAll(PageQuery query){
        return null;
    }

    @GetMapping("query-condition")
    @ApiOperation(value = "根据条件查询")
    public JsonVO<PageVO<RepairRevisitVO>> queryByCondition(RepairRevisitQuery query){
        return null;
    }

    @GetMapping("query-state")
    @ApiOperation(value = "查询所有报修回访的状态类型")
    public JsonVO<RepairRevisitStateVO> queryState(){
        return null;
    }

    @PostMapping("update")
    @ApiOperation("更新回访内容")
    public JsonVO<Integer> updateState(RepairRevisitDto dto){
        return null;
    }

    /**
     * 查询某一id的报修单详情
     * @return
     */
    @GetMapping("query-id")
    @ApiOperation(value = "查询某一id的报修单详情")
    public JsonVO<RepairDetailVO> queryById(@PathVariable String id){
        return null;
    }
}
