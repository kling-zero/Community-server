package com.zeroone.star.project.query.community.transactions.repairmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @Description 报修单设置信息查询对象
 * @Author Gerins
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("报修单设置信息查询对象")
public class RepairSettingQuery extends PageQuery {

    @NotBlank(message = "页码page不能为空")
    @ApiModelProperty(value = "page", example = "1")
    private Integer page;

    @NotBlank(message = "行数row不能为空")
    @ApiModelProperty(value = "row", example = "100")
    private Integer row;

    @NotBlank(message = "社区id不能为空")
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;

    @NotBlank(message = "是否为公共区域不能为空")
    @ApiModelProperty(value = "是否为公共区域", example = "F")
    private String publicArea;
}
