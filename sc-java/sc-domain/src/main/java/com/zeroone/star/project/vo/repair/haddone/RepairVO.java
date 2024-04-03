package com.zeroone.star.project.vo.repair.haddone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description 报修已办数据实体,对应view层展示的数据属性名
 * @Author 业峰
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@ApiModel("报修已办数据实体")
public class RepairVO {
    @ApiModelProperty(value = "报修ID", example = "822022101383861562")
    private String repairId;
    @ApiModelProperty(value = "位置", example = "30栋3单元z13142342室")
    private String communityId;
    @ApiModelProperty(value = "报修类型", example = "水管坏了")
    private String repairType;
    @ApiModelProperty(value = "报修人", example = "小明")
    private String repairName;
    @ApiModelProperty(value = "联系方式", example = "13112345678")
    private String tel;
    @ApiModelProperty(value = "预约时间", example = "2022-10-13 19:28:39")
    private Date appointmentTime;
    @ApiModelProperty(value = "状态", example = "办理完成")
    private String state;

}
