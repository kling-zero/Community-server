package com.zeroone.star.project.dto.community.transactions.parkingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */
@Data
@ApiModel("取消费用和手工结束传输数据对象")
public class DeleteParkingFeeDTO {
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "费用ID", example ="902022101665108171")
    private String feeId;
}
