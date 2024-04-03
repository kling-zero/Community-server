package com.zeroone.star.project.dto.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lht
 * @description
 * @date 2022/10/17
 */
@Data
@ApiModel("物业登录状态传输对象")
public class PropertyStateDTO {

    @ApiModelProperty(value = "物业id", example = "102022081507340568")
    private String storeId;

    @ApiModelProperty(value = "物业登录状态码  48001 商户正常状态 48002 限制商户登录", example = "48002")
    private String state;

    @ApiModelProperty(value = "物业登录状态名", example = "限制物业登录")
    private String stateName;
}
