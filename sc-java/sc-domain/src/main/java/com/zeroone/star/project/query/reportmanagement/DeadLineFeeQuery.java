package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: jiemo
 * @date: 2022/10/24 20:38
 * @description: 费用到期提醒查询对象
 */
@Data
@ApiModel("费用到期提醒查询对象")
public class DeadLineFeeQuery {
    @ApiModelProperty(value = "楼栋id", example = "732022083068440102")
    private String floorId;
    @ApiModelProperty(value = "楼栋名称", example = "1号楼")
    private String floorName;
    @ApiModelProperty(value = "房号", example = "1001")
    private String roomNum;
    @ApiModelProperty(value = "单元号", example = "742022083062970108")
    private String unitId;
    @ApiModelProperty(value = "小区id", example = "2022081539020475")
    private String communityId;
}
