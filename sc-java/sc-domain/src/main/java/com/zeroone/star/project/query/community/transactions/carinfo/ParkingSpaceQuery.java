package com.zeroone.star.project.query.community.transactions.carinfo;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("停车位查询条件对象")
public class ParkingSpaceQuery extends PageQuery {

    @ApiModelProperty(value = "停车场编号", example = "1")
    private String areaNum;

    @ApiModelProperty(value = "停车位编号", example = "1")
    private String spaceNum;
}
