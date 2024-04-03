package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("business_property_right_registration")
public class SaveBPRR {
    private String prrId;
    private String bId="";
    private String roomId;
    @TableField("name")
    private String name;
    private String link;
    private String idCard;
    private String address;
    private String createUser="";
    private String statusCd="";
    private String operate="";
    private String state;
    private String communityId;


}
