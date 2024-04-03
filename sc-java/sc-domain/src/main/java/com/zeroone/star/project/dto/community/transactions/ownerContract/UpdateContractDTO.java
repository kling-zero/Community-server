package com.zeroone.star.project.dto.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateContractDTO {
    @ApiModelProperty(value = "甲方联系人", example = "张三")
    private String aContacts;
    @ApiModelProperty(value = "甲方联系电话", example = "18888888888")
    private String aLink;
    @ApiModelProperty(value = "合同金额", example = "11111.00")
    private String amount;
    @ApiModelProperty(value = "乙方联系人", example = "lisi")
    private String bContacts;
    @ApiModelProperty(value = "乙方联系电话", example = "16602905643")
    private String bLink;
    @ApiModelProperty(value = "合同编码", example = "1212")
    private String contractCode;
    @ApiModelProperty(value = "合同类型", example = "812022100829630688")
    private String contractType;

}
