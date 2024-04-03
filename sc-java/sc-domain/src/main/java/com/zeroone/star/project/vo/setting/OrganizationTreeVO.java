package com.zeroone.star.project.vo.setting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("组织显示对象")
public class OrganizationTreeVO {
    @ApiModelProperty(value = "序号", example = "1")
    private String orgId;
    @ApiModelProperty(value = "组织名称", example = "xxx")
    private String orgName;
    @ApiModelProperty(value = "描述", example = "")
    private String description;
    @ApiModelProperty(value = "父级组织编号", example = "")
    private String parentOrgId;
}
