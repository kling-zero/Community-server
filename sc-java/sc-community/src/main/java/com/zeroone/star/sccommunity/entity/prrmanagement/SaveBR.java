package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("building_room")
public class SaveBR {
    @TableField("room_id")
    private String roomId;
    private String bId = "";
    private String roomNum;
    private String unitId;
    private String layer="";
    private String apartment = "";
    private BigDecimal built_up_area=BigDecimal.ZERO;
    private BigDecimal fee_coefficient = BigDecimal.ZERO;
    private String user_id = "";
    private String statusCd = "";
    private String state;
    private String communityId;
    private String room_type = "";
    private String room_sub_type = "";
    private BigDecimal room_area = BigDecimal.ZERO;
    private BigDecimal room_rent = BigDecimal.ZERO;
}
