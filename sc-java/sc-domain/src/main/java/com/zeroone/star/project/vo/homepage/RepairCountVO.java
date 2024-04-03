package com.zeroone.star.project.vo.homepage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 首页-报修统计对象
 * @Author j3小组-黑夜
 */
@ApiModel("主页-报修统计对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairCountVO {

    @ApiModelProperty(value = "全部报修", example = "30")
    private Integer total;

    @ApiModelProperty(value = "待派单", example = "5")
    private Integer standby;

    @ApiModelProperty(value = "处理中", example = "20")
    private Integer inProcess;

    @ApiModelProperty(value = "已处理", example = "5")
    private Integer handled;
}
