package com.zeroone.star.project.dto.rolePrivilege.roleFunction;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pzi
 * @create 2022-10-15 23:56
 */
@ApiModel("功能信息数据对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncitonDTO {

    @ApiModelProperty(value = "功能id", example = "1", required = true)
    private String functionId;

    @ApiModelProperty(value = "功能名字", example = "查看所有员工信息", required = true)
    private String functionName;


}
