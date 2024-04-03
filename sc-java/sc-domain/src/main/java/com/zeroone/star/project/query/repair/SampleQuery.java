package com.zeroone.star.project.query.repair;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @Description 示例查询对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("示例查询对象")
public class SampleQuery extends PageQuery {
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;
}
