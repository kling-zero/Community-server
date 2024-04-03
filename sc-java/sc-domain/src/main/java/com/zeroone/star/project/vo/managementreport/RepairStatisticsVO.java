package com.zeroone.star.project.vo.managementreport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修统计显示对象")
public class RepairStatisticsVO {
    @ApiModelProperty(value = "公共区域")
    private String area;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "数量")
    private int count;
}
