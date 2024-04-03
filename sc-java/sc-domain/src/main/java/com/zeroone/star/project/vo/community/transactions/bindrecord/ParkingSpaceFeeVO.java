package com.zeroone.star.project.vo.community.transactions.bindrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Tomcat
 * @Date 2022/10/16 16:10
 */
@Data
@ApiModel("车位费视图对象")
public class ParkingSpaceFeeVO {
    @ApiModelProperty(value ="总金额", example = "300.00")
    private String amount;
    @ApiModelProperty(value = "车位", example = "ASDSA-11停车场-1车位")
    private String carNum;
    @ApiModelProperty(value = "", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "缴费时间", example = " 2022-10-02 00:11:23")
    private Date createTime;
    @ApiModelProperty(value = "费用项目", example = "停车费")
    private String feeName;
    @ApiModelProperty(value = "", example = "888800010008")
    private String feeTypeCd;
    @ApiModelProperty(value = "", example = "802022100264163709")
    private String objId;
    @ApiModelProperty(value = "", example = "ASDSA-11停车场-1车位")
    private String objName;
    @ApiModelProperty(value = "", example = "6666")
    private String objType;
    @ApiModelProperty(value = "", example = " -1")
    private Integer page;
    @ApiModelProperty(value = "", example = "772022092792792481")
    private String payObjId;
    @ApiModelProperty(value = "业主", example = "王小勇")
    private String payObjName;
    @ApiModelProperty(value = "收据Id", example = "832022100250103417")
    private String receiptId;
    @ApiModelProperty(value = "", example = " 0 ")
    private Integer records;
    @ApiModelProperty(value = "", example = "10栋10001单元201室/2栋0单元2室/30栋1单元10001室")
    private String roomName;
    @ApiModelProperty(value = "当前页数据列表", example = " 0")
    private Integer row;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "", example = "演示物业")
    private String storeName;
    @ApiModelProperty(value = "总条数", example = " 0")
    private Integer total;

}
