package com.zeroone.star.project.query.repair.revisit;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报修回访查询条件实体类")
public class RepairRevisitQuery extends PageQuery {

    @ApiModelProperty(value = "报修类型", example = "水管坏了")
    private String repairType;

    @ApiModelProperty(value = "报修人姓名", example = "张杰")
    private String repairName;

    @ApiModelProperty(value = "回访状态", example = "待回访")
    private String state;

    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String id;

    @ApiModelProperty(value = "手机号", example = "18909711447")
    private String tel;

}
