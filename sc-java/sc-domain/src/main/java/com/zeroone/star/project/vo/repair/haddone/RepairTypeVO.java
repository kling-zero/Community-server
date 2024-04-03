package com.zeroone.star.project.vo.repair.haddone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 报修类型，返回前端，用于展示可选择的所有报修类型
 * @Author 业峰
 * @Copy &copy;01星球
 * @Address 01星球总部
 */

@Data
@ApiModel("报修类型")
public class RepairTypeVO {
    @ApiModelProperty(value = "报修类型", example = "水管坏了")
    private String repairType;
}
