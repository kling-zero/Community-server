package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 16:39
 * @description: 缴费明细筛选条件对象
 */
@Data
@ApiModel("缴费明细筛选条件对象")
public class LoadConditionQuery extends PageQuery {
    @ApiModelProperty(value = "小区id",example = "2022081539020475")
    private String communityId;
    @ApiModelProperty(value = "楼栋id", example = "732022083068440102")
    private String floorId;
    @ApiModelProperty(value = "费用类型", example = "888800010001")
    private String feeTypeCd;
}
