package com.zeroone.star.project.vo.community.transactions.buildfee;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 费用详情
 */
@Data
@ApiModel("费用详情显示对象")
public class FeeAttrVO {
    @ApiModelProperty(value = "属性Id", example = "112022101416137575")
    private String attrId;
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "费用Id", example = "902022101476217398")
    private String feeId;
    @ApiModelProperty(value = "页数", example = "-1")
    private int page;
    @ApiModelProperty(value = "记录", example = "0")
    private int records;
    @ApiModelProperty(value = "当前页数据列表")
    private int row;
    @ApiModelProperty(value = "数据状态，S保存 0在用 1失效", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "总条数", example = "0")
    private int total;
    @ApiModelProperty(value = "班次规格ID", example = "390007")
    private String specCd;
    @ApiModelProperty(value = "规格ID名称", example = "业主名称")
    private String specCdName;
    @ApiModelProperty(value = "值", example = "李四")
    private String value;

}
