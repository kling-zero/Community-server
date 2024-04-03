package com.zeroone.star.project.vo.repair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修设置类型视图对象")//显示给界面的
public class RepairSettingTypeVO {
    @ApiModelProperty(value = "报修设置类型", example = "100")
    private String repairSettingType;
}
