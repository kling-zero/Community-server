package com.zeroone.star.project.dto.community.transactions.buildingfee;


import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("创建费用传输数据对象")
public class FeeDTO {
    @ApiModelProperty(value = "结束时间", example = "2022-10-14 00:00:00")
    private Date endTime;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "金额", example = "-1.00")
    private String amount;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "5005")
    private String computingFormula;
    @ApiModelProperty(value = "费用ID", example = "922022092269180222")
    private String configId;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "位置类型，1000 大门 2000 单元门 3000 房屋门 4000 楼栋", example = "1000")
    private String locationTypeCd;
    @ApiModelProperty(value = "对象ID，大门时小区ID，单元门 时单元ID 房屋时房屋ID，楼栋时 楼栋ID", example = "752022100991611049")
    private String locationObjId;
    @ApiModelProperty(value = "楼ID")
    private String floorId;
    @ApiModelProperty(value = "楼编号")
    private String floorNum;
    @ApiModelProperty(value = "楼名称")
    private String floorName;
    @ApiModelProperty(value = "单元ID")
    private String unitId;
    @ApiModelProperty(value = "单元名称")
    private String unitName;
    @ApiModelProperty(value = "出账类型")
    private String billType;
    @ApiModelProperty(value = "房屋Id", example = "752022101002411137")
    private String roomId;
    @ApiModelProperty(value = "房屋状态", example = "2001,2003,2004,2005,2009")
    private String roomState;
    @ApiModelProperty(value = "房屋类型", example = "1010301")
    private String roomType;
    @ApiModelProperty(value = "", example = "false")
    private boolean isMore;
    @ApiModelProperty(value = "位置类型名称", example = "1栋1单元109室")
    private String locationTypeCdName;
    @ApiModelProperty(value = "费用层数", example = "全部")
    private String feeLayer;
    @ApiModelProperty(value = "状态周期")
    private String rateCycle;
    @ApiModelProperty(value = "状态")
    private String rate;
    @ApiModelProperty(value = "状态开始时间")
    private String rateStartTime;
    @ApiModelProperty(value = "收费项目显示对象")
    private List<FeeConfigsVO> feeConfigs;
    @ApiModelProperty(value = "支付类别展示对象")
    private List<FeeTypeCdsVO> feeTypeCds;
}
