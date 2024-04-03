package com.zeroone.star.project.query.community.transactions.buildingfee;


import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("根据费用类型查询收费项目对象")
public class FeeConfigsQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;
    @ApiModelProperty(value = "费用类型ID", example = "888800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "是否为默认值，T为默认值，F不是默认值", example = "F")
    private String isDefault;
    @ApiModelProperty(value = "有效期", example = "1")
    private Integer valid;
}
