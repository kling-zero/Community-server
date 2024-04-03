package com.zeroone.star.project.vo.community.transactions.reprintreceipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 补打收据视图对象
 *
 * @author Tomcat
 * @Date 2022 /10/15 21:57
 */
@Data
@ApiModel("补打收据视图对象")
public class ReprintReceiptVO {

    @ApiModelProperty(value = "房屋", example = "1-9009988")
    private String roomName;

    @ApiModelProperty(value = "业主", example = "222")
    private String ownerName;

    @ApiModelProperty(value = "费用项目", example = "铺租")
    private String feeName;

    @ApiModelProperty(value = "总金额", example = "15.00")
    private String amount;

    @ApiModelProperty(value = "缴费时间", example = "2022-10-14 18:32:58")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "收据ID", example = "832022101427557488")
    private String feeId;

    @ApiModelProperty(value = "车位", example = "-")
    private String parkingNum;

    @ApiModelProperty(value = "合同", example = "1212")
    private String businessName;

}
