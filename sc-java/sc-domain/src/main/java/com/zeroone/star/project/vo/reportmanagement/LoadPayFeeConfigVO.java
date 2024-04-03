package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 17:04
 * @description: 费用项视图对象
 */
@Data
@ApiModel("费用项视图对象")
public class LoadPayFeeConfigVO {
    @ApiModelProperty(value = "收费项id", example = "922022082235500040")
    private String configId;
    @ApiModelProperty(value = "收费项", example = "间接收费测试")
    private String feeName;
    @ApiModelProperty(value = "费用类型", example = "888800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "费用类型名称", example = "物业费")
    private String feeTypeCdName;
}
