package com.zeroone.star.project.vo.homepage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 首页-住户注册统计对象
 * @Author j3小组-黑夜
 */
@ApiModel("主页-住户注册统计对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCountVO {

    @ApiModelProperty(value = "未注册", example = "2")
    private Integer unregistered;

    @ApiModelProperty(value = "已注册", example = "2")
    private Integer registered;

    @ApiModelProperty(value = "未绑定房屋", example = "2")
    private Integer unBound;

    @ApiModelProperty(value = "已绑定房屋", example = "2")
    private Integer bound;
}
