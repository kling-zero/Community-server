package com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * The type Meter records query.
 *
 * @author Tomcat
 * @Date 2022 /10/16 10:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("绑定记录请求对象")
public class QueryShopsHireLogQuery extends PageQuery {
//    @NotBlank
//    @ApiModelProperty(value = "",example = "1")
//    private long page;
//
//    @NotBlank
//    @ApiModelProperty(value = "",example = "10")
//    private long row;

    @NotBlank
    @ApiModelProperty(value = "小区ID",example = "2022090665021542")
    private String communityId;

    @NotBlank
    @ApiModelProperty(value = "房间号",example = "1001")
    private String roomNum;

    @ApiModelProperty(value = "",example = "")
    private String meterType;
}
