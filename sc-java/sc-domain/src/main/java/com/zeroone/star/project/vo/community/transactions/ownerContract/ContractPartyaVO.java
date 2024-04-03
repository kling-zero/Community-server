package com.zeroone.star.project.vo.community.transactions.ownerContract;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("合同类型")
public class ContractPartyaVO extends PageVO {

    @ApiModelProperty(value = "甲方联系人", example = "张三")
    private String aContacts;
    @ApiModelProperty(value = "甲方联系电话", example = "18888888888")
    private String aLink;

    @ApiModelProperty(value = "甲方", example = "李四")
    private String partyA;
    @ApiModelProperty(value = "甲方主键", example = "282022092262510110")
    private String partyaId;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "商户ID", example = "102022090662291416")
    private String storeId;


}
