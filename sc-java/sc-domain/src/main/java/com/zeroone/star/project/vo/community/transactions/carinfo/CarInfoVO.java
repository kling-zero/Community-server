package com.zeroone.star.project.vo.community.transactions.carinfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 车辆信息VO
 */
@Data
@ApiModel("车辆信息对象")
public class CarInfoVO {

    @ApiModelProperty(value ="车辆ID", example = "01")
    private String carId;

    @ApiModelProperty(value ="车牌号", example = "10")
    private String carNum;

    @ApiModelProperty(value ="车辆品牌", example = "01")
    private String carBrand;

    @ApiModelProperty(value ="车辆类型", example = "家用汽车")
    private String carType;

    @ApiModelProperty(value ="颜色", example = "绿色")
    private String carColor;

    @ApiModelProperty(value ="业主", example = "小王(16602020123)")
    private String owner;

    @ApiModelProperty(value ="车位ID", example = "11")
    private String psId;

    @ApiModelProperty(value ="车位", example = "11车场11车位")
    private String parking;

    @ApiModelProperty(value ="起租时间", example = "2022-10-05 00:00:11")
    private LocalDateTime startTime;

    @ApiModelProperty(value ="截止时间", example = "2022-10-05 00:00:11")
    private LocalDateTime endTime;

    @ApiModelProperty(value ="状态", example = "车位释放")
    private String state;


}
