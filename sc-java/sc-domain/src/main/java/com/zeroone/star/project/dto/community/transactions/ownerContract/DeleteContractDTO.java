package com.zeroone.star.project.dto.community.transactions.ownerContract;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("删除合同传输对象")
public class DeleteContractDTO {

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
}
