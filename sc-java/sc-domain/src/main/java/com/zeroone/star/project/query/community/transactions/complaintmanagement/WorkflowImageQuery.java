package com.zeroone.star.project.query.community.transactions.complaintmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("投诉单流程图查询对象")
public class WorkflowImageQuery extends PageQuery {

    @NotBlank(message = "社区id不能为空")
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;

    @NotBlank(message = "审核业务key不能为空")
    @ApiModelProperty(value = "审核业务key", example = "882022101649363799")
    private String businessKey;
}
