package com.zeroone.star.project.vo.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("派单方式视图对象")//显示给界面的
public class RepairWayVo {
    @ApiModelProperty(value = "派单方式对应的数据表值", example = "100 抢单 200 指派 300 轮训")
    private int tDict;
    @ApiModelProperty(value = "派单方式", example = "200")
    private String repairWay;
}
