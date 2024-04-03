package com.zeroone.star.project.vo.community.transactions.buildfee;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@ApiModel("收费项目显示对象")
public class FeeConfigsVO {
    @ApiModelProperty(value = "收费周期，单位：月", example = "12")
    private BigDecimal additionalAmount;
    @ApiModelProperty(value = "周期类别，001-每年每月每日，002-每月每日，003-每日", example = "001")
    private String billType;
    @ApiModelProperty(value = "周期名", example = "每年1月1日")
    private String billTypeName;
    @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "1001")
    private String computingFormula;
    @ApiModelProperty(value = "计算公式名称", example = "面积*单价+附加费")
    private String computingFormulaName;
    @ApiModelProperty(value = "费用Id", example = "922022101488027646")
    private String configId;
    @ApiModelProperty(value = "是否账户抵扣, Y 默认,是 N 否", example = "N")
    private String deductFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", example = "2022-08-01 00:00:00")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "2006012")
    private String feeFlag;
    @ApiModelProperty(value = "费用标识名称", example = "一次性费用")
    private String feeFlagName;
    @ApiModelProperty(value = "费用项名称", example = "ABC小区物业费")
    private String feeName;
    @ApiModelProperty(value = "费用类型，物业费，停车费", example = "88800010001")
    private String feeTypeCd;
    @ApiModelProperty(value = "费用类型名称", example = "物业费")
    private String feeTypeCdName;
    @ApiModelProperty(value = "默认费用 只能修改 不能做删除 T 标识是默认 F 不是默认", example = "F")
    private String isDefault;
    @ApiModelProperty(value = "付费类型", example = "1200")
    private String paymentCd;
    @ApiModelProperty(value = "缴费周期", example = "1")
    private String paymentCycle;
    @ApiModelProperty(value = "每平米收取的单价", example = "1")
    private BigDecimal squarePrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", example = "2022-08-01 00:00:00")
    private LocalDateTime startTime;
}
