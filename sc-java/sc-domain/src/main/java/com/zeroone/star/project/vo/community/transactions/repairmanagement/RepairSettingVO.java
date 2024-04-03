package com.zeroone.star.project.vo.community.transactions.repairmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("电话报修设置对象")
public class RepairSettingVO {

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "处理开始时间", example = "2022-10-15 11:26:06")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "page", example = "-1")
    private Integer page;

    @ApiModelProperty(value = "是否收费 T为是 F为否", example = "F")
    private String payFeeFlag;

    @ApiModelProperty(value = "收费范围，如30元至50元", example = "不收费")
    private String priceScope;

    @ApiModelProperty(value = "是否为公共区域", example = "F")
    private String publicArea;

    @ApiModelProperty(value = "records", example = "0")
    private Integer records;

    @ApiModelProperty(value = "备注", example = "嘿嘿")
    private String remark;

    @ApiModelProperty(value = "报修设置类型", example = "200")
    private String repairSettingType;

    @ApiModelProperty(value = "报修设置类型名称", example = "维修单")
    private String repairSettingTypeName;

    @ApiModelProperty(value = "报修类型", example = "102022101547731634")
    private String repairType;

    @ApiModelProperty(value = "报修类型名称", example = "马桶维修")
    private String repairTypeName;

    @ApiModelProperty(value = "派单方式 t_dict 100 抢单 200 指派 300 轮训", example = "200")
    private String repairWay;

    @ApiModelProperty(value = "派单方式名称", example = "指派")
    private String repairWayName;

    @ApiModelProperty(value = "是否回访标识符", example = "001")
    private String returnVisitFlag;

    @ApiModelProperty(value = "是否回访", example = "都不回访")
    private String returnVisitFlagName;

    @ApiModelProperty(value = "row", example = "0")
    private Integer row;

    @ApiModelProperty(value = "工单设置ID", example = "102022101547731634")
    private String settingId;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;

    @ApiModelProperty(value = "total", example = "0")
    private Integer total;


}
