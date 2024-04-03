package com.zeroone.star.project.vo.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PrintContractVO {

    @ApiModelProperty(value = "模板ID", example = "822022100974140690")
    private List<ContractTypeTmplateVO> contractTypeTemplate;

    @ApiModelProperty(value = "模板ID", example = "822022100974140690")
    private List<OwnerContractVO> contract;

}
