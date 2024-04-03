package com.zeroone.star.project.query.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

@Data
@ApiModel("受理房产查询对象")
public class AcceptHousePropertyQuery{
    @ApiModelProperty(value = "查询类型", example = "1")
    private String searchType;
    @ApiModelProperty(value = "查询值", example = "1-1-1")
    private String searchValue;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
}
