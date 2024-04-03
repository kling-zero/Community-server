package com.zeroone.star.project.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @date 2022-10-16 - 4:34
 *   @Description 小区配置查询
 *  *@Author Colins
 */
@Getter
@Setter
public class CommunityConfigQuery {
    @ApiModelProperty(value = "配置名称")
    private String configName;
    @ApiModelProperty(value = "查询键名称")
    private String configKeyName;
}
