package com.zeroone.star.project.vo.managementreport;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
@Data
@ApiModel("报修明细显示对象")
public class RepairDetailVO {
    @ApiModelProperty(value = "工单号")
    private String workOrder;

    @ApiModelProperty(value = "报修类型")
    private String type;

    @ApiModelProperty(value = "报修申请人")
    private String applicant;

    @ApiModelProperty(value = "报修位置")
    private String address;

    @ApiModelProperty(value = "报修电话")
    private String phoneNumber;

    @ApiModelProperty(value = "工单状态")
    private String orderStatus;

    @ApiModelProperty(value = "报修时间")
    private String applicationTime;

    @ApiModelProperty(value = "上一处理人")
    private String lastHandler;

    @ApiModelProperty(value = "当前处理人")
    private String currentHandler;

    @ApiModelProperty(value = "派单时间")
    private Date sendingDate;

    @ApiModelProperty(value = "处理时间")
    private Date executionDate;

    @ApiModelProperty(value = "处理人状态")
    private String handlerStatus;
}
