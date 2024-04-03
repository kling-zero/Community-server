package com.zeroone.star.project.vo.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContractTypeTmplateVO {
    @ApiModelProperty(value = "合同内容", example = "电话#qwe#合同编号#qwe#甲方联系电话#ewq#合同编号##甲方联系电话##甲方联系")
    private String context;
    @ApiModelProperty(value = "合同类型ID", example = "812022100829630688")
    private String contractTypeId;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "商户ID", example = "102022090662291416")
    private String storeId;
    @ApiModelProperty(value = "模板ID", example = "822022100974140690")
    private String templateId;
}
