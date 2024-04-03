package com.zeroone.star.project.query.reportmanagement;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: jiemo
 * @date: 2022/10/24 17:02
 * @description: 缴费明细表查询对象
 */
@Data
@ApiModel("缴费明细表查询对象")
public class PayFeeDetailQuery extends PageQuery {
    @ApiModelProperty(value = "楼栋id", example = "732022083068440102")
    private String floorId;
    @ApiModelProperty(value = "楼栋名称", example = "1号楼")
    private String floorName;
    @ApiModelProperty(value = "房号", example = "1001")
    private String roomNum;
    @ApiModelProperty(value = "收费项id", example = "922022082235500040")
    private String configId;
    @ApiModelProperty(value = "支付方式", example = "")
    private String primeRate;
//    @ApiModelProperty(value = "费用状态", example = "")
//    private String state;
    @ApiModelProperty(value = "费用类型", example = "888800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "开始时间", example = "2022-08-01 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "结束时间", example = "2022-09-30 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "单元id", example = "742022083062970108")
    private String unitId;
    @ApiModelProperty(value = "小区id", example = "2022081539020475")
    private String communityId;
}
