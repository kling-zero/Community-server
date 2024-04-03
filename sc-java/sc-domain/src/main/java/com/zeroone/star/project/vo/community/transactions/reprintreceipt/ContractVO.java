package com.zeroone.star.project.vo.community.transactions.reprintreceipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请选择车辆 VO对象
 */
@Data
@ApiModel("请选择合同 VO")
public class ContractVO {

    @ApiModelProperty(value = "合同名称", example = "合同1")
    private String businessName;

    @ApiModelProperty(value = "合同ID", example = "1")
    private String businessId;
}
