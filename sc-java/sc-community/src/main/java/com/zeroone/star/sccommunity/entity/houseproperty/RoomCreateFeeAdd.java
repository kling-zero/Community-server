package com.zeroone.star.sccommunity.entity.houseproperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/21
 */
@Getter
@Setter
public class RoomCreateFeeAdd implements Serializable {
    private Double additionalAmount;
    private String billType;
    private String billTypeName;
    private String computingFormula;
    private String computingFormulaName;
    private String computingFormulaText;
    private String configId;
    private String deductFrom;
    private LocalDate endTime;
    private String feeFlag;
    private String feeFlagName;
    private String feeName;
    private String feeTypeCd;
    private String isDefault;
    private String paymentCd;
    private String paymentCycle;
    private Double squarePrice;
    private LocalDate startTime;
}
