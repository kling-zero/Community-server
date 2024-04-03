package com.zeroone.star.project.query.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */

@Data
@ApiModel("创建房屋费用显示对象")
public class RoomCreateFeeAddVO extends PageVO {
    @ApiModelProperty(value = "附加费用",example = "0.00")
    private BigDecimal additionalAmount;
    @ApiModelProperty(value = "出账类型编号",example = "004")
    private String billType;
    @ApiModelProperty(value = "出账类型编号对应的出账名",example = "每年1月1日")
    private String billTypeName;
    @ApiModelProperty(value = "计算公式编号",example = "1001")
    private String computingFormula;
    @ApiModelProperty(value = "计算公式编号对应的计算公式",example = "面积*单价+附加费 ")
    private String computingFormulaName;
    @ApiModelProperty(value = "'自定义公式内容",example = "面积*单价")
    private String computingFormulaText;
    @ApiModelProperty(value = "费用ID",example = "922022092479831530")
    private String configId;
    @ApiModelProperty(value = "是否账户抵扣",example = "Y")
    private String deductFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间",example = "2050-01-01 00:00:00")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "费用标识编号",example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用标识编号对应的费用标识名",example = "一次性费用")
    private String feeFlagName;
    @ApiModelProperty(value = "费用项名称",example = "2020楼梯费")
    private String feeName;
    @ApiModelProperty(value = "费用类型",example = "物业费")
    private String feeTypeCd;
    @ApiModelProperty(value = "'默认费用",example = "T")
    private String isDefault;
    @ApiModelProperty(value = "付费类型",example = "1200")
    private String paymentCd;
    @ApiModelProperty(value = "缴费周期",example = "1")
    private String paymentCycle;
    @ApiModelProperty(value = "每平米收取的单价",example = "0.00")
    private BigDecimal squarePrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间",example = "2010-01-01 00:00:00")
    private LocalDateTime startTime;
}
