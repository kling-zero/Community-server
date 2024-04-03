package com.zeroone.star.project.vo.community.transactions.repairmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@ApiModel("工单详情显示对象")
public class RepairStaffVO {

    @ApiModelProperty(value = "业务id", example = "-1")
    private String bId;

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;

    @ApiModelProperty(value = "意见", example = "订单提交")
    private String context;

    @ApiModelProperty(value = "处理开始时间", example = "2022-10-15 17:10:51")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "耗时", example = "提交")
    private String duration;

    @ApiModelProperty(value = "处理结束时间", example = "2022-10-15 17:10:51")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "page", example = "-1")
    private Integer page;

    @ApiModelProperty(value = "photoVos", example = "")
    private Object[] photoVos;

    @ApiModelProperty(value = "上一节点处理ID", example = "-1")
    private String preRuId;

    @ApiModelProperty(value = "上一节点处理员工", example = "-1")
    private String preStaffId;

    @ApiModelProperty(value = "上一节点处理员工名称", example = "-1")
    private String preStaffName;

    @ApiModelProperty(value = "records", example = "0")
    private Integer records;

    @ApiModelProperty(value = "事件，startUser 开始用户 auditUser 审核处理员工", example = "startUser")
    private String repairEvent;

    @ApiModelProperty(value = "报修id", example = "822022101541831670")
    private String repairId;

    @ApiModelProperty(value = "row", example = "0")
    private Integer row;

    @ApiModelProperty(value = "报修派单ID", example = "832022101500301712")
    private String ruId;

    @ApiModelProperty(value = "当前处理员工", example = "302022090667451419")
    private String staffId;

    @ApiModelProperty(value = "当前处理员工名称", example = "wuxw")
    private String staffName;

    @ApiModelProperty(value = "开始时间", example = "2022-10-15 23:00:33")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "员工处理状态，请查看t_dict表", example = "10005")
    private String state;

    @ApiModelProperty(value = "员工处理状态名称", example = "提交")
    private String stateName;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;

    @ApiModelProperty(value = "total", example = "0")
    private Integer total;





}
