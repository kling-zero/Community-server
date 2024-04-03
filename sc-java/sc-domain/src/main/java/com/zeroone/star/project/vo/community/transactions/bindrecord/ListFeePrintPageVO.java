package com.zeroone.star.project.vo.community.transactions.bindrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * The type List fee print page vo.
 *
 * @author Tomcat
 * @Date 2022 /10/16 15:47
 */
@Data
@ApiModel("打印视图对象")
public class ListFeePrintPageVO {
    @ApiModelProperty(value ="", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "", example = " -1")
    private Integer page;
    @ApiModelProperty(value = "", example = "102022101350667285")
    private String pageId;
    @ApiModelProperty(value = "", example = "ont1")
    private String pageName;
    @ApiModelProperty(value = "", example = "4")
    private String pageUrl;
    @ApiModelProperty(value = "", example = " 0")
    private Integer records;
    @ApiModelProperty(value = "当前页数据列表", example = " 0")
    private Integer row;
    @ApiModelProperty(value = "", example = "T")
    private String state;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "", example = "祥云物流园区")
    private String templateName;
    @ApiModelProperty(value = "总条数", example = " 0")
    private Integer total;
    @ApiModelProperty(value = "图片或视频地址", example = "/print.html#/pages/property/printPayFeeXiangyun")
    private String url;
}
