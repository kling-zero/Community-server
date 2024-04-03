package com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("停车区域显示对象")
public class ParkingAreaVO {
    @ApiModelProperty(value = "")
    private String paId;
    @ApiModelProperty(value = "")
    private String TypeCd;
    @ApiModelProperty(value = "备注",example = "null")
    private String remark;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date createTime;
    @ApiModelProperty(value = "数量", example = "11")
    private int num;
    @ApiModelProperty(value = "")
    private List<CarAttrsVO> attrs;


}
