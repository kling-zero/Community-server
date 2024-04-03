package com.zeroone.star.project.query.community.transactions.carinfo;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("车辆信息查询条件对象")
public class CarInfoQuery extends PageQuery {

    @ApiModelProperty(value = "业主ID", example = "302022081574590429")
    private String ownerId;
}
