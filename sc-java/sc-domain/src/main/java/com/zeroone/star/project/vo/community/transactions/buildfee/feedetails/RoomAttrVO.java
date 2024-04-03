package com.zeroone.star.project.vo.community.transactions.buildfee.feedetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("房间详细信息显示对象")
public class RoomAttrVO {
    @ApiModelProperty(value = "属性Id", example = "112022101416137575")
    private String attrId;
    @ApiModelProperty(value = "是否展示在list页面 Y 是 N 不是", example = "Y")
    private String listShow;
    @ApiModelProperty(value = "房屋Id", example = "752022082030880010")
    private String roomId;
    @ApiModelProperty(value = "班次规格ID", example = "390007")
    private String specCd;
    @ApiModelProperty(value = "规格名称", example = "业主名称")
    private String specName;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "值", example = "李四")
    private String value;
    @ApiModelProperty(value = "值名称")
    private String valueName;
}
