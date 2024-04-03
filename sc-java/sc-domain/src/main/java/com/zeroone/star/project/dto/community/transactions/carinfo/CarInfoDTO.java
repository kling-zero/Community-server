package com.zeroone.star.project.dto.community.transactions.carinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 车辆信息DTO
 */
@Data
@ApiModel("车辆信息DTO对象")
public class CarInfoDTO {

    @ApiModelProperty(value = "汽车ID", example = "1")
    private String carId;

    @ApiModelProperty(value = "车位ID", example = "792022102093321981")
    private String psId;

    @ApiModelProperty(value ="业主ID", example = "166020201231231241")
    private String ownerId;

    @ApiModelProperty(value ="车牌号", example = "10")
    private String carNum;

    @ApiModelProperty(value ="车辆品牌", example = "01")
    private String carBrand;

    @ApiModelProperty(value ="车辆类型", example = "家用汽车")
    private String carType;

    @ApiModelProperty(value ="颜色", example = "绿色")
    private String carColor;

    @ApiModelProperty(value = "车牌类型", example = "出售车辆")
    private String carNumType;

    @ApiModelProperty(value = "业主车辆", example = "是")
    private String carTypeCd;

    @ApiModelProperty(value = "备注", example = "备注信息")
    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="起租时间", example = "2022-10-05 00:00:11")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="结租时间", example = "2022-10-05 00:00:11")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "成员ID", example = "12341241231243")
    private String memberId;

    @ApiModelProperty(value = "小区ID", example = "12341412412412")
    private String communityId;

    @ApiModelProperty(value = "业务ID", example = "124124124124")
    private String bId;

    @ApiModelProperty(value = "用户ID", example = "124124124124")
    private String userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", example = "2022-10-05 00:00:11")
    private LocalDateTime createTime;
}
