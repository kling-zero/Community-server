package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: jiemo
 * @date: 2022/10/25 16:32
 * @description: 预交费提醒视图对象
 */
@Data
@ApiModel("预交费提醒视图对象")
public class PrepaymentVO {
    @ApiModelProperty(value = "房号", example = "1栋1单元1001室")
    private String objName;
    @ApiModelProperty(value = "车牌号", example = "粤A12345")
    private String carNum;
    @ApiModelProperty(value = "费用项", example = "物业费")
    private String feeName;
    @ApiModelProperty(value = "费用开始时间", example = "2022-11-1 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "距离费用开始时间", example = "2")
    private String oweDay;
}
