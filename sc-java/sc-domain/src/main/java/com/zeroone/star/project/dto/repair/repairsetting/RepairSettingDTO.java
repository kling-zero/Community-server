package com.zeroone.star.project.dto.repair.repairsetting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author iceberg-work
 */
@Data
@ApiModel("报修设置传输数据对象")
public class RepairSettingDTO {

    @ApiModelProperty(value = "工单设置ID", example = "102022091615272002")
    private String settingId;

    @ApiModelProperty(value = "报修类型名称", example = "测试1")
    private String repairTypeName;

    @ApiModelProperty(value = "派单方式 t_dict 100 抢单 200 指派 300 轮训", example = "100")
    private String repairWay;

    @ApiModelProperty(value = "报修设置类型", example = "100")
    private String repairSettingType;

    @ApiModelProperty(value = "备注", example = "你好")
    private String remark;

    @ApiModelProperty(value = "是否为公共区域", example = "T")
    private String publicArea;

    @ApiModelProperty(value = "是否收费 T为是 F为否", example = "F")
    private String payFeeFlag;

    @ApiModelProperty(value = "收费范围，如30元至50元", example = "不收费")
    private String priceScope;

    @ApiModelProperty(value = "回访标识 001 都不回访 002 已评价不回访 003 都回访", example = "001")
    private String returnVisitFlag;

    @NotBlank(message = "小区分片ID不能为空")
    @ApiModelProperty(value = "小区分片ID", example = "2022090665021542")
    private String communityId;
}
