package com.zeroone.star.project.vo.community.transactions.bindrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/10/16 16:47
 */
@Data
@ApiModel("打印视图对象")
public class QueryContractVO {
    @ApiModelProperty(value ="总金额", example = "2720.00")
    private String amount;
    @ApiModelProperty(value ="合同", example = "111111")
    private String carNum;
    @ApiModelProperty(value = "", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "缴费时间", example = " 2022-10-04 15:43:02")
    private Date createTime;
    @ApiModelProperty(value = "费用项目", example = "测试租金01")
    private String feeName;
    @ApiModelProperty(value = "", example = "888800010018")
    private String feeTypeCd;
    @ApiModelProperty(value = "", example = "812022100420780652")
    private String objId;
    @ApiModelProperty(value = "合同", example = "111111")
    private String objName;
    @ApiModelProperty(value = "", example = "7777")
    private String objType;
    @ApiModelProperty(value = "", example = " -1 ")
    private Integer page;
    @ApiModelProperty(value = "", example = "772022092792792481")
    private String payObjId;
    @ApiModelProperty(value = "业主", example = "王小勇")
    private String payObjName;
    @ApiModelProperty(value = "收据Id", example = "832022100407763520")
    private String receiptId;
    @ApiModelProperty(value = "", example = " 0 ")
    private Integer records;
    @ApiModelProperty(value = "", example = "-")
    private String roomName;
    @ApiModelProperty(value = "当前页数据列表", example = " 0 ")
    private Integer row;
    @ApiModelProperty(value = "", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "", example = "演示物业")
    private String storeName;
    @ApiModelProperty(value = "总条数", example = " 0")
    private Integer total;
}
