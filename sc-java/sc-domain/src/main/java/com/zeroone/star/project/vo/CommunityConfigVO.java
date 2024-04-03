package com.zeroone.star.project.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2022-10-16 - 4:43
 * @Description 小区配置信息查询
 * @Author Colins
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityConfigVO {
    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称", example = "费用")
    private String typeName;
    /**
     * 配置名称
     */
    @ApiModelProperty(value = "配置名称", example = "实收款开关")
    private Integer configName;
    /**
     * 配置KEY
     */
    @ApiModelProperty(value = "配置KEY", example = "RECEIVED_AMOUNT_SWITCH")
    private Integer configKey;
    /**
     * 配置取值
     */
    @ApiModelProperty(value = "配置取值", example = "0")
    private Integer configValue;
}
