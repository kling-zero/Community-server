package com.zeroone.star.project.query.sample.communitymanage.busaccept.bindrecord;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author Tomcat
 * @Date 2022/10/16 16:54
 */
public class QueryContractQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "",example = "1")
    private long page;

    @NotBlank
    @ApiModelProperty(value = "",example = "10")
    private long row;

    @NotBlank
    @ApiModelProperty(value = "",example = "")
    private String objId;

    @NotBlank
    @ApiModelProperty(value = "管理员唯一标识",example = "2022090665021542")
    private String communityId;
}
