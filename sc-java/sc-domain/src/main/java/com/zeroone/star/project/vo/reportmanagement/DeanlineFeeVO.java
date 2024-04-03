package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: jiemo
 * @date: 2022/10/25 16:20
 * @description: 费用到期提醒视图对象
 */
@Data
@ApiModel("费用到期提醒视图对象")
public class DeanlineFeeVO {
    @ApiModelProperty(value = "房号", example = "1栋0单元101室")
    private String objName;
    @ApiModelProperty(value = "车牌号", example = "粤A12345")
    private String carNum;
    @ApiModelProperty(value = "费用项", example = "物业费")
    private String feeName;
    @ApiModelProperty(value = "费用结束时间", example = "2022-10-31 00:00:00")
    private Date deadlineTime;
    @ApiModelProperty(value = "距离费用结束时间", example = "1")
    private String oweDay;
}
