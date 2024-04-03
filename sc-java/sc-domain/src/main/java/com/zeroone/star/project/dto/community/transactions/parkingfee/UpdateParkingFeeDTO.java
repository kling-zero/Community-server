package com.zeroone.star.project.dto.community.transactions.parkingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */
@Data
@ApiModel("费用变动传输数据对象")
public class UpdateParkingFeeDTO {
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式编号",example = "1001")
    private String computingFormula;
    @ApiModelProperty(value = "结束时间",example = "2050-01-01 00:00:00")
    private LocalDate endTime;
    @ApiModelProperty(value = "费用标识编号",example = "1003006 为周期性费用 2006012 为一次性费用")
    private String feeFlag;
    @ApiModelProperty(value = "费用ID", example ="902022101665108171")
    private String feeId;
    @ApiModelProperty(value = "最大终止时间")
    private String maxEndTime;
    @ApiModelProperty(value = "利率")
    private String rate;
    @ApiModelProperty(value = "利率周期")
    private String rateCycle;
    @ApiModelProperty(value = "利率开始时间")
    private String rateStartTime;
    @ApiModelProperty(value = "开始时间",example = "2010-01-01 00:00:00")
    private LocalDate startTime;




}
