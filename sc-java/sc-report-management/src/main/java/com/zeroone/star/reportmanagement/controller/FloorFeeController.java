package com.zeroone.star.reportmanagement.controller;

import com.zeroone.star.project.query.reportmanagement.FeeDetailQuery;
import com.zeroone.star.project.query.reportmanagement.FloorFeeQuery;
import com.zeroone.star.project.reportmanagement.FloorFeeApi;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.reportmanagement.FeeDetailVO;
import com.zeroone.star.project.vo.reportmanagement.FloorFeeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: FloorFeeController
 * @Author: Freasy
 * @Description: 楼栋费用表的controller
 * @Date: 2022/10/25 19:31
 * @Version: 1.0
 */
@RequestMapping("/reportManager/floor-fee")
@Api(tags = "楼栋费用表")
public class FloorFeeController implements FloorFeeApi {

    @GetMapping("/query")
    @ApiOperation("条件查询")
    @Override
    public List<JsonVO<PageVO<FloorFeeVO>>> queryByCondition(FloorFeeQuery condition) {
        return null;
    }

    @GetMapping("/detail")
    @ApiOperation("查看楼栋费用明细")
    @ApiModelProperty(value = "测试接口",example = "测试生成器代码是否有问题")
    @Override
    public List<JsonVO<PageVO<FeeDetailVO>>> showDetail(FeeDetailQuery condition) {
        return null;
    }
}
