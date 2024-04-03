package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 17:38
 * @description: 楼房单元视图对象
 */
@Data
@ApiModel("楼房单元视图对象")
public class LoadUnitsVO {
    @ApiModelProperty(value = "单元id", example = "742022083062970108")
    private String unitId;
    @ApiModelProperty(value = "单元号", example = "742022083062970108")
    private String unitNum;
}
