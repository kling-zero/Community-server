package com.zeroone.star.project.dto.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName TelephoneModifyDTO
 * @Description 电话报修修改记录数据传输对象
 * @Author Colin
 * @Date 2022/10/13 20:38
 * @Version 1.0
 */
@Data
@ApiModel("电话报修修改记录数据传输对象")
public class TelephoneModifyDTO {
    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String repairId;
    @ApiModelProperty(value = "小区ID", example = "822022082245830070")
    private String communityId;
    @ApiModelProperty(value = "报修对象ID", example = "752022082030880010")
    private String repairObjId;
    @ApiModelProperty(value = "报修对象名称", example = "D-1-1001")
    private String repairObjName;
    @ApiModelProperty(value = "报修对象类型", example = "004")
    private String repairObjType;
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
//    @ApiModelProperty(value = "报修渠道", example = "T")
//    private String repairChannel;
    @ApiModelProperty(value = "报修人", example = "张杰")
    private String repairName;
    @ApiModelProperty(value = "联系方式", example = "18909711447")
    private String tel;
    @ApiModelProperty(value = "预约时间", example = "2022-08-22 11:15:38")
    private Timestamp appointmentTime;
    //    @ApiModelProperty(value = "报修状态", example = "未派单")
//    private String state;
    @ApiModelProperty(value = "报修内容", example = "测试记录112")
    private String context;
    //缺少报修设置对象
//    private RepairSettingsDTO repairSettings;
}
