package com.zeroone.star.project.vo.community.transactions.buildfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("房屋费用显示对象")
public class BuildingFeesVO {
    @ApiModelProperty(value = "费用显示对象")
    List<FeesVO> fees;
    @ApiModelProperty(value = "页数", example = "0")
    private int page;
    @ApiModelProperty(value = "记录", example = "1")
    private int records;
    @ApiModelProperty(value = "当前页数据列表")
    private Integer rows;
    @ApiModelProperty(value = "总条数", example = "6")
    private int total;
}
