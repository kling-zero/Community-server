package com.zeroone.star.project.query.community.structure.carStructure;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @Description 车位结构查询对象
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("车位结构查询对象")
public class CarStructureQuery extends PageQuery {

    @NotBlank(message = "小区ID不能为空")
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @NotBlank(message = "单元ID不能为空")
    @ApiModelProperty(value = "单元ID",example = "742022100941011053")
    private String unitId;

}
