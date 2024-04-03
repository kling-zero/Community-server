package com.zeroone.star.project.vo.community.transactions.reprintreceipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 费用类型VO对象
 */
@Data
@ApiModel("补打收据视图对象")
public class FeeTypeVO {

    @ApiModelProperty(value = "费用类型字符串", example = "房屋费")
    private String feeType;

    @ApiModelProperty(value = "费用类型对应的编号", example = "01")
    private String feeTypeCd;
}
