package com.zeroone.star.project.vo.reportmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: jiemo
 * @date: 2022/10/25 17:44
 * @description: 字典视图对象
 */
@Data
@ApiModel("字典视图对象")
public class LoadDictVO {
    @ApiModelProperty(value = "描述", example = "物业费")
    private String description;
    @ApiModelProperty(value = "名称", example = "物业费")
    private String name;
    @ApiModelProperty(value = "表字段状态 取值", example = "888800010001")
    private String statusCd;
}
