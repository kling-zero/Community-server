package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("property_right_registration_detail")
public class SavePRRDetail {
    private String prrdId;
    private String prrId;
    private String securities="";
    private String isTrue;
    private String createUser="";
    private String statusCd="";
    private String deedTaxUrl="";



}
