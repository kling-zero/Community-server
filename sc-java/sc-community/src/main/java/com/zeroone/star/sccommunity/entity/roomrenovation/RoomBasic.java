package com.zeroone.star.sccommunity.entity.roomrenovation;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("room_renovation")
public class RoomBasic implements Serializable {
    @ApiModelProperty(value = "小区ID", example = "2022090665021542")
    private String communityId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", example = "2022-10-09 19:40:15")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", example = "2022-10-31 23:59:59")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "是否延期", example = "Y")
    private String isPostpone;
    @ApiModelProperty(value = "是否违规", example = "Y")
    private String isViolation;
    @ApiModelProperty(value = "装修主要负责人", example = "qqq")
    private String personMain;
    @ApiModelProperty(value = "负责人联系方式", example = "15705187697")
    private String personMainTel;
    @ApiModelProperty(value = "联系人", example = "EricWang")
    private String personName;
    @ApiModelProperty(value = "联系电话", example = "15705187697")
    private String personTel;
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    @ApiModelProperty(value = "延期时间", example = "2022-11-09")
    private Date postponeTime;
    @TableId(value = "r_id" ,type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID", example = "172022100943551097")
    private String rId;
    @ApiModelProperty(value = "备注", example = "qqq")
    private String remark;
    @ApiModelProperty(value = "装修公司", example = "qqq")
    private String renovationCompany;
    @ApiModelProperty(value = "房屋ID", example = "752022100987340783")
    private String roomId;
    @ApiModelProperty(value = "房屋名称", example = "21-01-501")
    private String roomName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", example = "2022-10-10 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "状态", example = "状态 1000 待审核 2000 审核不通过 3000 装修中 4000 待验收 5000 验收成功 6000 验收失败 ")
    private String state;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "审核备注", example = "0")
    private String examineremark;

}
