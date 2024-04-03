package com.zeroone.star.project.vo.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel("强制回单视图对象")//显示给界面的
public class ForceFinishVO {
    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String repairId;
    @ApiModelProperty(value = "报修对象ID", example = "752022082030880010")
    private String repairObjId;
    @ApiModelProperty(value = "报修对象名称", example = "D-1-1001")
    private String repairObjName;
    @ApiModelProperty(value = "报修对象类型", example = "004")
    private String repairObjType;
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
    @ApiModelProperty(value = "报修类型名称", example = "测试报修")
    private String repairTypeName;
    @ApiModelProperty(value = "报修设置类型", example = "100")
    private String repairSettingType;
    @ApiModelProperty(value = "报修设置类型名称", example = "保洁单")
    private String repairSettingTypeName;
    @ApiModelProperty(value = "报修人", example = "张杰")
    private String repairName;
    @ApiModelProperty(value = "联系方式", example = "18909711447")
    private String tel;
    @ApiModelProperty(value = "预约时间", example = "2022-08-22 11:15:38")
    private Timestamp appointmentTime;
    @ApiModelProperty(value = "报修状态", example = "1000")
    private String state;
    @ApiModelProperty(value = "订单创建时间", example = "2022-08-22 10:53:43")
    private String createTime;

}
