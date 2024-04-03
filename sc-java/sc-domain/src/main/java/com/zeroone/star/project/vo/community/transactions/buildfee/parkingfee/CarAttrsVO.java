package com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("车辆详情显示对象")

public class CarAttrsVO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "属性Id", example = "112022101416137575")
    private String attrId;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "班次规格ID", example = "390007")
    private String specCd;
    @ApiModelProperty(value = "规格ID名称", example = "业主名称")
    private String specCdName;
    @ApiModelProperty(value = "值", example = "李四")
    private String value;
    @ApiModelProperty(value = "是否列表展示",example = "Y")
    private String listShow;
    @ApiModelProperty(value = "")
    private String paId;
    @ApiModelProperty(value = "2233 input 3344 select 4455 日期",example = "2233")
    private String statuType;
}
