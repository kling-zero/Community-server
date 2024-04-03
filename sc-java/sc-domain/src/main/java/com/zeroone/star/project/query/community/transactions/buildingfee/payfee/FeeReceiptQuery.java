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
@ApiModel("费用收据查询对象")
public class FeeReceiptQuery extends PageVO {
    @NotBlank
    @ApiModelProperty(value = "保证金ID", example = "800.00")
    private String detailId;
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
}
