package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: MFM
 */


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("业主缴费查询对象")
public class OwnerPaymentQuery extends PageQuery {

    @ApiModelProperty(value = "收费项目")
    private String feeTypeCd;

    @ApiModelProperty(value = "房屋Id")
    private String roomId;

    @ApiModelProperty(value = "小区Id")
    private String communityId;
}
