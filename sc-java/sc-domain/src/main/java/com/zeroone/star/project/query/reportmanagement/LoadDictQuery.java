package com.zeroone.star.project.query.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 16:52
 * @description: 字典查询对象
 */

@Data
@ApiModel("字典查询对象")
public class LoadDictQuery {
    @ApiModelProperty(value = "表名",example = "pay_fee_config")
    private String name;
    @ApiModelProperty(value = "字段名",example = "fee_type_cd")
    private String type;
}
