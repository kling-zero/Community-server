package com.zeroone.star.project.query.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 报修类型
 * 报修人
 * 手机号
 * 报修ID
 * 报修状态
 */
@Data
@ApiModel("查询条件扩展子类")
public class ChildQuery extends FatherQuery {
    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String repairId;
    @ApiModelProperty(value = "报修状态", example = "待回访")
    private String state;
}
