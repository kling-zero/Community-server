package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("组织与员工关系数据传输对象")
public class Organization_PersonnelDto {
    @ApiModelProperty(value = "组织员工id", example = "1")
    private String relId;
    @ApiModelProperty(value = "业务id", example = "1")
    private String bId;
    @ApiModelProperty(value = "组织id", example = "1")
    private String orgId;
    @ApiModelProperty(value = "员工id", example = "1")
    private String staffId;
    @ApiModelProperty(value = "关系角色", example = "1")
    private String relCd;
    @ApiModelProperty(value = "创建时间", example = "1")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "数据状态", example = "1")
    private String status_cd;
    @ApiModelProperty(value = "商户id", example = "1")
    private String storeId;
}
