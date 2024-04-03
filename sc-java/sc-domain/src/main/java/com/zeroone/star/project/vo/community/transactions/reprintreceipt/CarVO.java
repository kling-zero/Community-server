package com.zeroone.star.project.vo.community.transactions.reprintreceipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请选择车辆 VO对象
 */
@Data
@ApiModel("请选择车辆 VO")
public class CarVO {

    @ApiModelProperty(value = "车辆名称", example = "车1")
    private String carName;

    @ApiModelProperty(value = "车辆对应ID", example = "01")
    private String carId;
}
