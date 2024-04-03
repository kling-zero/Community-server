package com.zeroone.star.project.dto.setting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Iris
 * @create 2022-10-15-19:50
 * @email 2015245811@qq.com
 */
@Data
@ApiModel("修改密码传输对象")
public class ModifyPasswordDTO {

    @ApiModelProperty(value = "编号", example = "1")
    private Integer id;
    @ApiModelProperty(value = "旧密码", example = "2222as")
    private String passwordOld;
    @ApiModelProperty(value = "新密码", example = "111")
    private String passwordNew;
}
