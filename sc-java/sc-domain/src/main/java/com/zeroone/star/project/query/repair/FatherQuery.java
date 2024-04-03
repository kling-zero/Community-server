package com.zeroone.star.project.query.repair;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 报修类型
 * 报修人
 * 手机号
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("查询条件父类")
public class FatherQuery extends PageQuery {
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
    @ApiModelProperty(value = "报修人", example = "张杰")
    private String repairName;
    @ApiModelProperty(value = "手机号", example = "18909711447")
    private String tel;
}
