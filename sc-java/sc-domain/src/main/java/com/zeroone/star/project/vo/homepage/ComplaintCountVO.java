package com.zeroone.star.project.vo.homepage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 首页-投诉统计对象
 * @Author j3小组-黑夜
 */
@ApiModel("投诉统计对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintCountVO {

    @ApiModelProperty(value = "全部投诉", example = "34")
    private Integer allComplaints;

    @ApiModelProperty(value = "处理中", example = "10")
    private Integer inProcess;

    @ApiModelProperty(value = "已处理", example = "5")
    private Integer processed;
}
