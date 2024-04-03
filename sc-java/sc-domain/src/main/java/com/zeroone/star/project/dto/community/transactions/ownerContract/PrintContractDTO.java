package com.zeroone.star.project.dto.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrintContractDTO {
    @ApiModelProperty(value = "合同ID", example = "812022100947920849")
    private String contractId;
    @ApiModelProperty(value = "合同类型ID", example = "812022100947920849")
    private String contractTypeID;
}
