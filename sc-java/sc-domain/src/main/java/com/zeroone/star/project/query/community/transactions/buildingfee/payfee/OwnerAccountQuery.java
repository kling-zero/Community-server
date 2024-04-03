package com.zeroone.star.project.query.community.transactions.buildingfee.payfee;

import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("账户信息查询对象")
public class OwnerAccountQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;

    @ApiModelProperty(value = "费用ID", example = "902022082082950026")
    private String feeId;
}
