package com.zeroone.star.project.query;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Description 分页查询父类对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Getter
@Setter
@ToString
public class PageQuery {
    @NotNull
    @Min(value = 1, message = "页码最小值为1")
    @ApiModelProperty(value = "查询页码", example = "1",required = true)
    @ApiParam(required = true)
    private long pageIndex;

    @NotNull
    @ApiParam(required = true)
    @Min(value = 1, message = "条数最小值为1")
    @ApiModelProperty(value = "查询条数", example = "10",required = true)
    private long pageSize;
}
