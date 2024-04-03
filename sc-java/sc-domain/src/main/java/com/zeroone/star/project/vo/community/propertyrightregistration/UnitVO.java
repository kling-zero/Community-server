package com.zeroone.star.project.vo.community.propertyrightregistration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("单元显示对象")
public class UnitVO {
    @ApiModelProperty(value = "楼层id", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼层编号", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "单元id", example = "742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号", example = "0")
    private String unitNum;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "是否有电梯 1010有 2020 无",example = "0")
    private String lift;
    @ApiModelProperty(value = "楼栋加入排序",example = "0")
    private Integer seq;
    @ApiModelProperty(value = "总层数",example = "31")
    private Integer layerCount;
    @ApiModelProperty(value = "单元面积",example = "31")
    private Double unit_area;
}
