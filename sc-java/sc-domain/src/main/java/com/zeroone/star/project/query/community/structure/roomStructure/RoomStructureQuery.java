package com.zeroone.star.project.query.community.structure.roomStructure;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @Description 楼栋结构查询对象
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("楼栋结构查询对象")
public class RoomStructureQuery extends PageQuery {
    @NotBlank(message = "小区ID不能为空")
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @NotBlank(message = "单元ID不能为空")
    @ApiModelProperty(value = "单元ID",example = "742022082058950007")
    private String unitId;
}
