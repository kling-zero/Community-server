package com.zeroone.star.project.vo.sample;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * The type Sample vo.
 *
 * @Description 示例视图对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@ApiModel("示例显示对象")
public class SampleVO {
    @ApiModelProperty(value = "编号", example = "1")
    private Integer id;
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;
}
