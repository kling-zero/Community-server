package com.zeroone.star.project.query.community.transactions.parkingfee;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("停车费用查询数据对象")
public class ParkingCarQuery extends PageQuery {
    @NotBlank(message = "页码page不能为空")
    @ApiModelProperty(value = "page", example = "1")
    private Integer page;

    @NotBlank(message = "行数row不能为空")
    @ApiModelProperty(value = "row", example = "10")
    private Integer row;

    @NotBlank(message = "社区id不能为空")
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;

    @NotBlank(message = "停车费用对象id不能为空")
    @ApiModelProperty(value = "停车费用对象id", example = "752022100910441032")
    private String payerObjId;
}
