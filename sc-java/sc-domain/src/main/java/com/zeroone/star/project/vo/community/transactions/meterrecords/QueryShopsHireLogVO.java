package com.zeroone.star.project.vo.community.transactions.meterrecords;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 抄表记录视图对象
 *
 * @author Tomcat
 * @Date 2022 /10/16 10:15
 */
@Data
@ApiModel("抄表记录视图对象")
public class QueryShopsHireLogVO {
    @ApiModelProperty(value ="", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example = " 2022-10-15 21:24:55")
    private Date createTime;
    @ApiModelProperty(value = "本期度数", example = "1001.00")
    private String curDegrees;
    @ApiModelProperty(value = "本期读表时间", example = " 2022-10-15 21:24:50")
    private Date curReadingTime;
    @ApiModelProperty(value = "", example = "902022101599537868")
    private String feeId;
    @ApiModelProperty(value = "", example = "102022090813867155")
    private String meterType;
    @ApiModelProperty(value = "表类型", example = "水费抄表")
    private String meterTypeName;
    @ApiModelProperty(value = "", example = "752022100815210720")
    private String objId;
    @ApiModelProperty(value = "对象名称", example = "1栋0单元9009988室")
    private String objName;
    @ApiModelProperty(value = "", example = "3333")
    private String objType;
    @ApiModelProperty(value = "上期度数", example = "1000.00")
    private String preDegrees;
    @ApiModelProperty(value = "上期读表时间", example = " 2022-10-08 17:03:53")
    private Date preReadingTime;
    @ApiModelProperty(value = "", example = " 0.0")
    private Integer price;
    @ApiModelProperty(value = "", example = "")
    private String remark;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "", example = "102022101519367873")
    private String waterId;
    /*以下数据是page信息不需要返回
    @ApiModelProperty(value = "总条数", example = " 0")
    private Integer total;
    @ApiModelProperty(value = "当前页数据列表", example = " 0")
    private Integer row;
    @ApiModelProperty(value = "", example = " -1")
    private Integer page;
     */
    /*数据库没有该字段
    @ApiModelProperty(value = "", example = " 0")
    private Integer records;
     */
}
