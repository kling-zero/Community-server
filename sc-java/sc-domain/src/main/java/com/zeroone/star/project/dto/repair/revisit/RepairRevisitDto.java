package com.zeroone.star.project.dto.repair.revisit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 报修回访修改数据传输对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@ApiModel("报修回访修改数据传输对象")
public class RepairRevisitDto {
    @ApiModelProperty(value = "工单编码",example = "822022101109111223")
    private String id;
    @ApiModelProperty(value = "回访满意度",example = "满意")
    private String state;
    @ApiModelProperty(value = "回访内容",example = "回访内容")
    private String Description;
}
