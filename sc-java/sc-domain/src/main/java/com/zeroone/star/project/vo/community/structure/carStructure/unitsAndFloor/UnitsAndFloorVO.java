package com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor;

import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@Data
@ApiModel("楼栋单元显示对象")
//为什么要extends JsonVO？
public class UnitsAndFloorVO {
    @ApiModelProperty(value = "楼ID", example ="732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "总层数", example ="31")
    private Integer layerCount;
    @ApiModelProperty(value = "是否有电梯", example ="1010")
    private String lift;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "单元面积", example ="1.00")
    private Double unitArea;
    @ApiModelProperty(value = "单元ID", example ="742022100941011053")
    private String unitId;
    @ApiModelProperty(value = "单元编号", example ="1")
    private String unitNum;
    @ApiModelProperty(value = "楼编号", example ="1")
    private String floorNum;
    @ApiModelProperty(value = "楼栋加入排序", example ="1")
    private Integer seq;
}
