package com.zeroone.star.project.dto.community.transactions.repairmanagement;

import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description 电话报修数据传输对象
 * @Author Gerins
 */
@Data
@ApiModel("电话报修数据传输对象")
public class OwnerRepairManageDTO {

    @ApiModelProperty(value = "报修id", example = "")
    private String repairId;

    @ApiModelProperty(value = "报修类型", example = "102022101082921168")
    private String repairType;

    @ApiModelProperty(value = "报修人", example = "Gerins5")
    private String repairName;

    @ApiModelProperty(value = "联系方式", example = "15955998899")
    private String tel;

    @ApiModelProperty(value = "预约时间", example = "2022-10-15 22:42:09")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "报修内容", example = "Gerins电气坏了")
    private String context;

    @ApiModelProperty(value = "报修对象类型 001 小区 002 楼栋 003 单元 004 房屋", example = "004")
    private String repairObjType;

    @ApiModelProperty(value = "报修对象id", example = "752022100910441032")
    private String repairObjId;

    @ApiModelProperty(value = "报修对象名称", example = "1栋1单元1室")
    private String repairObjName;

    @ApiModelProperty(value = "报修设置信息", example = "")
    private List<RepairSettingVO> repairSettings;

    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;



}
