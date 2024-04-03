package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("property_right_registration_detail")
public class UpdatePPRDetail {
    private String prrdId;
    private String prrId;
    private String securities;
    private String isTrue;

    private String deedTaxUrl;
    private String idCardUrl;
    private String housePurchaseUrl;
    private String repairUrl;



}
