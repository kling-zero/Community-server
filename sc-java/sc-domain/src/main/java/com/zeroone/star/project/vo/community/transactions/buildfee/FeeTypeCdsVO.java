package com.zeroone.star.project.vo.community.transactions.buildfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("费用类别展示对象")
public class FeeTypeCdsVO {
    @ApiModelProperty(value = "服务描述", example = "现金")
    private String description;
    @ApiModelProperty(value = "服务ID", example = "0")
    private int id;
    @ApiModelProperty(value = "服务名称", example = "现金")
    private String name;
    @ApiModelProperty(value = "数据状态，详细参考c_status表", example = "888800010001")
    private String statusCd;
}
