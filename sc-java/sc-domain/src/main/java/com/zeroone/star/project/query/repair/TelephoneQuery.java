package com.zeroone.star.project.query.repair;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName TelephoneQuery
 * @Description 电话报修查询对象
 * @Author Colin
 * @Date 2022/10/13 16:27
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("电话报修查询对象")
public class TelephoneQuery extends PageQuery {
    @ApiModelProperty(value = "报修ID", example = "822022082245830070")
    private String repairId;
    @ApiModelProperty(value = "报修人", example = "张杰")
    private String repairName;
    @ApiModelProperty(value = "报修电话", example = "18909711447")
    private String tel;
    @ApiModelProperty(value = "报修类型", example = "102022082220310068")
    private String repairType;
    @ApiModelProperty(value = "报修状态", example = "1000")
    private String state;
}
