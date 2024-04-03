package com.zeroone.star.project.query.cpp;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 示例查询对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("C++示例查询对象")
public class SampleQuery extends PageQuery {
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
}
