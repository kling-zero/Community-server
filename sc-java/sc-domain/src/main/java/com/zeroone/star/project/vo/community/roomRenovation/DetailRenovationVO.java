package com.zeroone.star.project.vo.community.roomRenovation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 详细装修信息
 *
 * @author ahu
 * @date 2022/10/15
 */
@Data
public class DetailRenovationVO {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建时间", example = "2022-09-15 09:05:37")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "明细ID", example = "912022091501661918")
    private String detailId;
    @ApiModelProperty(value = "明细类型", example = "1001")
    private String detailType;
    @ApiModelProperty(value = "装修ID", example = "172022091519491917")
    private String rId;
    @ApiModelProperty(value = "备注", example = "1")
    private String remark;
    @ApiModelProperty(value = "验房人ID", example = "302022090667451419")
    private String staffId;
    @ApiModelProperty(value = "验房人", example = "wuxw")
    private String staffName;
    @ApiModelProperty(value = "状态", example = "3000")
    private String state;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
}
