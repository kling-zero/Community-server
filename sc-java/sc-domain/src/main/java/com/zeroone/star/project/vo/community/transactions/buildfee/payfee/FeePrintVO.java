package com.zeroone.star.project.vo.community.transactions.buildfee.payfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("费用打印显示对象")
public class FeePrintVO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "页面ID", example = "102022101350667285")
    private String pageId;
    @ApiModelProperty(value = "页面名称", example = "ont1")
    private String pageName;
    @ApiModelProperty(value = "收据页面", example = "4")
    private String pageUrl;
    @ApiModelProperty(value = "状态，T有效，F无效", example = "T")
    private String state;
    @ApiModelProperty(value = "数据状态，1失效，0有效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "模板名称", example = "祥云物流园区")
    private String templateName;
    @ApiModelProperty(value = "url路径", example = "/print.html#/pages/property/printPayFeeXiangyun")
    private String url;
}
