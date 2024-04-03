package com.zeroone.star.project.vo.community.transactions.bindrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Tomcat
 * @Date 2022/10/16 9:37
 */
@Data
@ApiModel("房屋费视图对象")
public class QueryFeeReceiptVO {
    @ApiModelProperty(value = "创建时间", example = " 2022-10-09 14:47:30")
    private Date createTime;
    @ApiModelProperty(value = "结束时间", example = " 2022-10-08 23:05:06")
    private Date endTime;
    @ApiModelProperty(value = "业主电话", example = "18574931443")
    private String link;
    @ApiModelProperty(value = "业主名称", example = "222")
    private String name;
    @ApiModelProperty(value = "", example = "772022100831114782")
    private String ownerId;
    @ApiModelProperty(value = "", example = " -1")
    private Integer page;
    @ApiModelProperty(value = "", example = " 0")
    private Integer records;
    @ApiModelProperty(value = "", example = "752022100815210720")
    private String roomId;
    @ApiModelProperty(value = "当前页数据列表", example = " 0")
    private Integer row;
    @ApiModelProperty(value = "开始时间", example = " 2022-10-08 21:05:06")
    private Date startTime;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "总条数", example = "0")
    private Integer total;

}
