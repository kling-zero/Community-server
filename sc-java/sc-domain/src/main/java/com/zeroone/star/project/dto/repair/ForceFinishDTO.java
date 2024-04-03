package com.zeroone.star.project.dto.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel("能够强制回单的师傅对象")//从界面传输回来的
public class ForceFinishDTO {
    @ApiModelProperty(value = "工单编码",example = "822022101585481711")
    private String repairId;
    @ApiModelProperty(value = "位置", example = "822022082245830070")
    private String communityId;
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
    @ApiModelProperty(value = "报修人",example = "Gerins4")
    private String repairName;
    @ApiModelProperty(value = "联系方式",example = "18956787656")
    private String tel;
    @ApiModelProperty(value = "预约时间", example = "2022-08-22 11:15:38")
    private Timestamp appointmentTime;
    @ApiModelProperty(value = "状态",example = "接单")
    private String state;
}
