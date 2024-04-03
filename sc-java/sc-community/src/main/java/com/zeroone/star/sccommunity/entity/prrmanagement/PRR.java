package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("property_right_registration")
public class PRR {
    private String prrId;
    private String roomId;
    private String name;
    private String link;
    private String idCard;
    private String address;
    private String state;
    private String communityId;
    private String floorId;
    private String floorNum;
    private int page;
    private String roomNum;
    private int row;
    private String unitId;
    private String unitNum;
}
