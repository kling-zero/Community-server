package com.zeroone.star.project.dto.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryContractFileDTO {
    @ApiModelProperty(value = "合同ID", example = "812022100947920849")
    private String contractId;
}
