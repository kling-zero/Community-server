package com.zeroone.star.project.query.community.transactions.buildingfee.payfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("根据周期查询账户信息查询对象")
public class OwnerAccountCycleQuery extends OwnerAccountQuery{
    @NotBlank
    @ApiModelProperty(value = "周期，单位月", example = "12")
    private int cycle;
}
