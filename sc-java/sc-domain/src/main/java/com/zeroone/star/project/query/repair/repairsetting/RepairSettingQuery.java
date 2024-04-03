package com.zeroone.star.project.query.repair.repairsetting;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author iceberg-work
 */
@Data
@ApiModel("报修设置查询对象")
public class RepairSettingQuery extends PageQuery {

    @ApiModelProperty(value = "报修类型名称", example = "测试1")
    private String repairTypeName;

    @ApiModelProperty(value = "派单方式 t_dict 100 抢单 200 指派 300 轮训", example = "100")
    private String repairWay;

    @ApiModelProperty(value = "报修类型", example = "100")
    private String repairType;

    @NotBlank(message = "小区分片ID不能为空")
    @ApiModelProperty(value = "小区分片ID", example = "2022090665021542")
    private String communityId;
}
