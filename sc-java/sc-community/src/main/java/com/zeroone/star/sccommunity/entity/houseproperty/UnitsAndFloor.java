package com.zeroone.star.sccommunity.entity.houseproperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/22
 */
@Getter
@Setter
public class UnitsAndFloor implements Serializable {
    private String floorId;
    private String floorNum;
    private Integer layerCount;
    private String lift;
    private String remark;
    private Integer seq;
    private Double unitArea;
    private String unitId;
    private String unitNum;
}
