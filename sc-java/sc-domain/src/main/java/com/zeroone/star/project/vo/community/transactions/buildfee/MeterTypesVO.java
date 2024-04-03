package com.zeroone.star.project.vo.community.transactions.buildfee;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("抄表类型显示对象")
public class MeterTypesVO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example = "2022-10-14 00:00:00")
    private Date createTime;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "数据状态，详细参考c_status表，S 保存，0, 在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "类型ID", example = "102022101185175747")
    private String typeId;
    @ApiModelProperty(value = "类型名称", example = "水费抄表")
    private String typeName;
}
