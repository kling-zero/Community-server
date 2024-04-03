package com.zeroone.star.project.vo.community.propertyrightregistration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("审核下拉列表视图")
@AllArgsConstructor
@NoArgsConstructor
public class StateVO {
    @ApiModelProperty(value = "审核状态", example = "未审核、审核通过、审核不通过")
    private String state;
}
