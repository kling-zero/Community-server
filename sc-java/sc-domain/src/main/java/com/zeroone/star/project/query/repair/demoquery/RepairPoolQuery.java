package com.zeroone.star.project.query.repair.demoquery;

import com.zeroone.star.project.query.repair.ChildQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工单池查询")
public class RepairPoolQuery extends ChildQuery {

    @ApiModelProperty(value = "报修设置类型", example = "100")
    private String repairSettingType;

}
