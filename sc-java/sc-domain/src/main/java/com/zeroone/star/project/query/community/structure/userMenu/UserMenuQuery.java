package com.zeroone.star.project.query.community.structure.userMenu;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户菜单")
public class UserMenuQuery extends PageQuery {
//    @NotBlank(message = "页数不能为空")
//    @ApiModelProperty(value = "第几页", example = "1")
//    private Integer page;

//    @NotBlank(message = "行数不能为空")
//    @ApiModelProperty(value = "取几行", example = "100")
//    private Integer row;
}
