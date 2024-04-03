package com.zeroone.star.project.dto.community.propertyrightregistration;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ApiModel("删除房屋产权基本信息")
public class DeletePPRDTO {
    @ApiModelProperty(value = "地址", example = "广东")
    private String address;
    @ApiModelProperty(value = "小区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "创建者", example = "-1")
    private String createUser;

    @ApiModelProperty(value = "创建时间",example = "2022-10-21 17:51:05")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "身份证", example = "430426199904112355")
    private String idCard;
    @ApiModelProperty(value = "联系方式", example = "15552671478")
    private String link;
    @ApiModelProperty(value = "姓名", example = "lzq")
    private String name;
    @ApiModelProperty(value = "", example = "1")
    private int page;
    @ApiModelProperty(value = "主键id", example = "102022091264671742")
    private String prrId;
    @ApiModelProperty(value = "", example = "0")
    private int records;
    @ApiModelProperty(value = "备注", example = "通过")
    private String remark;
    @ApiModelProperty(value = "房屋id", example = "752022091443581870")
    private String roomId;
    @ApiModelProperty(value = "", example = "0")
    private int row;
    @ApiModelProperty(value = "审核状态", example = "0")
    private String state;
    @ApiModelProperty(value = "审核名称", example = "未审核")
    private String stateName;
    @ApiModelProperty(value = "statusCd", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "total", example = "0")
    private int total;
}
