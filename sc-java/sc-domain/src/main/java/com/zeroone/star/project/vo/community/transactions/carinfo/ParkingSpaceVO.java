package com.zeroone.star.project.vo.community.transactions.carinfo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 停车位VO
 */
@Data
@ApiModel("停车位VO对象")
public class ParkingSpaceVO {

    @ApiModelProperty(value = "车位ID", example = "792022102093321981")
    private String psId;

    @ApiModelProperty(value = "编号", example = "7")
    private String num;

    @ApiModelProperty(value = "停车场", example = "03-912")
    private String parkingArea;

    @ApiModelProperty(value = "车位状态", example = "空闲")
    private String state;

    @ApiModelProperty(value = "面积", example = "77.00平方米")
    private String area;

    @ApiModelProperty(value = "备注", example = "很大")
    private String remark;
}
