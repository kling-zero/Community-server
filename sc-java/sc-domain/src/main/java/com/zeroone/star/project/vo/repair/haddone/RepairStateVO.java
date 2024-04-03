package com.zeroone.star.project.vo.repair.haddone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 报修类型，返回前端，用于展示可选择的所有报修状态
 * @Author 业峰
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@ApiModel("报修状态")
public class RepairStateVO {
        @ApiModelProperty(value = "报修类型",example = "办理完成")
        private String state;
}
