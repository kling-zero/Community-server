package com.zeroone.star.project.vo.community.transactions.ownerContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ContraTypeVO {
    @ApiModelProperty(value = "是否需要审核", example = "是否需要审核，1001 需要审核 2002 不需要审核 3003 需要admin审核  4004 需要 代理商审核")
    private String audit;
    @ApiModelProperty(value = "审核状态名称", example = "不审核")
    private String auditName;
    @ApiModelProperty(value = "合同类型ID", example = "812022101297851453")
    private String contractTypeId;
    @ApiModelProperty(value = "创建时间", example = " 2022-10-12 17")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "合同描述", example = "合同描述")
    private String remark;

    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "商户ID", example = "102022090662291416")
    private String storeId;

    @ApiModelProperty(value = "合同类型名称", example = "入住合同test")
    private String typeName;

}
