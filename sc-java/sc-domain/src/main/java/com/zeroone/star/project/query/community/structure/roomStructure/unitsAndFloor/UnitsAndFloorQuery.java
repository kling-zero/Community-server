package com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor;


import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description 楼栋单元结构查询对象
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("楼栋单元结构查询对象")
public class UnitsAndFloorQuery extends PageQuery {
    @NotBlank(message = "小区ID不能为空")
    @ApiModelProperty(value = "小区ID", example ="2022081539020475")
    private String communityId;
}