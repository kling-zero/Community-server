package com.zeroone.star.project.query.community.transactions.reprintreceipt;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("补打收据查询条件对象")
public class ReceiptQuery extends PageQuery {

    @ApiModelProperty(value = "房间ID", example = "12341234")
    private String roomId;

    @ApiModelProperty(value = "成员ID", example = "1234523525")
    private String memberId;

    @ApiModelProperty(value = "收费类型", example = "1")
    private String CostType;

    @ApiModelProperty(value = "房屋", example = "全部房屋")
    private String buildingCondition;

    @ApiModelProperty(value = "车辆ID", example = "0123")
    private String carId;

    @ApiModelProperty(value = "车辆", example = "全部车辆")
    private String carCondition;

    @ApiModelProperty(value = "合同ID", example = "0123")
    private String bId;

    @ApiModelProperty(value = "小区ID", example = "12934124")
    private String communityId;
}
