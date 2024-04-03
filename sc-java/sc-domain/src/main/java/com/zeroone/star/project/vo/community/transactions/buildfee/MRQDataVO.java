package com.zeroone.star.project.vo.community.transactions.buildfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel("根据抄表查询数据显示对象")
public class MRQDataVO {
    @ApiModelProperty(value = "费用Id", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "本期度数", example = "0.00")
    private String curDegrees;
    @ApiModelProperty(value = "本期读表时间", example = "2022-10-15 03:00:50")
    private Date curReadingTime;
    @ApiModelProperty(value = "上期度数", example = "0.00")
    private String preDegrees;
    @ApiModelProperty(value = "上期读表时间", example = "2022-10-15 13:39:49")
    private Date preReadingTime;
    @ApiModelProperty(value = "抄表名称", example = "水费抄表")
    private String meterTypeName;
    @ApiModelProperty(value = "对象名称", example = "1栋1单元1室")
    private String objName;
    @ApiModelProperty(value = "价格", example = "0")
    private int price;
    @ApiModelProperty(value = "水费ID", example = "102022101556357858")
    private String waterId;
    @ApiModelProperty(value = "对象ID", example = "752022101002411137")
    private String objId;
    @ApiModelProperty(value = "对象类型", example = "3333")
    private String objType;
    @ApiModelProperty(value = "抄表类型", example = "102022090813867155")
    private String meterType;
    @ApiModelProperty(value = "创建时间", example = "2022-10-14 00:00:00")
    private Date createTime;
    @ApiModelProperty(value = "备注", example = "无")
    private String remark;
    @ApiModelProperty(value = "数据状态，详细参考c_status表，S 保存，0, 在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "页数", example = "1")
    private int page;
    @ApiModelProperty(value = "条数", example = "100")
    private int row;
    @ApiModelProperty(value = "记录", example = "0")
    private int records;
    @ApiModelProperty(value = "总条数", example = "0")
    private int total;
}
