package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("组织数据传输对象")
public class OrganizationDto {

    @ApiModelProperty(value = "组织id", example = "1")
    private String orgId;

    @ApiModelProperty(value = "业务id", example = "1")
    private String bId;

    @ApiModelProperty(value = "商户id", example = "1")
    private String storeId;

    @ApiModelProperty(value = "组织名称", example = "abc")
    private String orgName;

    @ApiModelProperty(value = "组织级别", example = "1")
    private String orgLevel;

    @ApiModelProperty(value = "上级组织", example = "1")
    private String parentOrgId;

    @ApiModelProperty(value = "组织描述", example = "xxx")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "数据状态", example = "1")
    private String statusCd;

    @ApiModelProperty(value = "归属小区", example = "1")
    private String belongCommunityId;

    @ApiModelProperty(value = "允许前台操作数据", example = "T")
    private String allowOperation;
}
