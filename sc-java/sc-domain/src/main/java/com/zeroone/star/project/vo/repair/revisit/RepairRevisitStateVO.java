package com.zeroone.star.project.vo.repair.revisit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 报修回访状态视图对象，返回前端，用于展示可选择的所有报修状态
 * @Author 业峰
 * @Copy &copy;01星球
 * @Address 01星球总部
 */

@Data
@ApiModel("报修回访状态视图对象")
public class RepairRevisitStateVO {
    @ApiModelProperty(value = "回访状态类型",example = "待回访")
    private String state;
}
