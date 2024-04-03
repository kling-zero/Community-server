package com.zeroone.star.sccommunity.entity.prrmanagement;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("building_unit")
public class SaveBU {
    private String unitId;

    private String unitNum;
    private String floorId;

    private int layer_count =0;
    private String lift = "";
    private String user_id = "";
    private String statusCd = "";
    private BigDecimal unit_area = BigDecimal.ZERO;

}
