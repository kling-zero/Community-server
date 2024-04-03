package com.zeroone.star.project.query.community.transactions.ownerMember;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("家庭成员查询")
@EqualsAndHashCode(callSuper = true)
public class OwnerMemberQuery extends PageQuery {
    @ApiModelProperty(value = "小区ID", example ="2022081539020475")
    private String communityId;
    @ApiModelProperty(value = "业主ID",example = "772022081789310004")
    private String ownerId;
}
