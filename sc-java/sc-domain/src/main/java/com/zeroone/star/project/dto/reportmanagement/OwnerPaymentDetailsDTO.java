package com.zeroone.star.project.dto.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: MFM
 */

@Data
@ApiModel("业主缴费明细传输对象")
public class OwnerPaymentDetailsDTO {
    @ApiModelProperty(value = "业主名字", example = "test001")
    private String owner;

    @ApiModelProperty(value = "房屋", example = "D-1-1001")
    private String roomName;

    @ApiModelProperty(value = "费用项目", example = "888800010001")
    private String feeTypeCd;

    @ApiModelProperty(value = "1月", example = "0")
    private Integer month1;

    @ApiModelProperty(value = "2月", example = "0")
    private Integer month2;

    @ApiModelProperty(value = "3月", example = "0")
    private Integer month3;

    @ApiModelProperty(value = "4月", example = "0")
    private Integer month4;

    @ApiModelProperty(value = "5月", example = "0")
    private Integer month5;

    @ApiModelProperty(value = "6月", example = "0")
    private Integer month6;

    @ApiModelProperty(value = "7月", example = "0")
    private Integer month7;

    @ApiModelProperty(value = "8月", example = "200")
    private Integer month8;

    @ApiModelProperty(value = "9月", example = "0")
    private Integer month9;

    @ApiModelProperty(value = "10月", example = "0")
    private Integer month10;

    @ApiModelProperty(value = "11月", example = "0")
    private Integer month11;

    @ApiModelProperty(value = "12月", example = "0")
    private Integer month12;

    @ApiModelProperty(value = "合计", example = "200")
    private Integer sum;

    @ApiModelProperty(value = "应收", example = "200")
    private Integer receivable;

    @ApiModelProperty(value = "预收", example = "100")
    private Integer preReceivable;


}
