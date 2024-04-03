package com.zeroone.star.project.query.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */
@Data
@ApiModel("付费配置显示对象")
public class PayFeeConfigVO {
    @ApiModelProperty(value = "介绍",example = "押金")
    private String description;
    @ApiModelProperty(value = "小区名称",example = "演示物业（误删）")
    private String name;
    @ApiModelProperty(value = "数据状态",example = "0")
    private String statusCd;
}