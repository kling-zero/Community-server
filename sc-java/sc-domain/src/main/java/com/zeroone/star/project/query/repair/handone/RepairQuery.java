package com.zeroone.star.project.query.repair.handone;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 报修已办查询，对应查询条件的属性名
 * @Author 业峰
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@ApiModel("报修已办查询")
@Data
public class RepairQuery extends PageQuery {

    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String id;

    @ApiModelProperty(value = "报修人姓名", example = "张杰")
    private String repairName;

    @ApiModelProperty(value = "手机号", example = "18909711447")
    private String tel;

    @ApiModelProperty(value = "报修类型", example = "水管坏了")
    private String repairType;

    @ApiModelProperty(value = "报修状态", example = "办理完成")
    private String state;
}
