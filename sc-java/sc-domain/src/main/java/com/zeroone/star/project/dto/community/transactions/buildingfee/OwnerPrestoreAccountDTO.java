package com.zeroone.star.project.dto.community.transactions.buildingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("预存账户金额传输数据对象")
public class OwnerPrestoreAccountDTO {
    @ApiModelProperty(value = "手机号码")
    private String tel;
    @ApiModelProperty(value = "所有者Id", example = "2022-10-14 00:00:00")
    private String ownerId;
    @ApiModelProperty(value = "所有者")
    private List<String> owners;
    @ApiModelProperty(value = "金额", example = "100")
    private String amount;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "实收金额", example = "30.00")
    private String receivedAmount;
    @ApiModelProperty(value = "存款金额", example = "0")
    private int redepositAmount;
    @ApiModelProperty(value = "总金额", example = "30")
    private String totalAmount;
    @ApiModelProperty(value ="账户类型，2003 现金账户 2004 积分账户 2005 优惠券账户", example = "2003")
    private String acctType;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
}
