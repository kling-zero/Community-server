package com.zeroone.star.project.query.community.propertyrightregistration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("产权详细信息")
public class PRRDetailQuery extends PageQuery {
    @ApiModelProperty(value = "主键id", example = "112022092225820132")
    private String prrdId;
    @ApiModelProperty(value = "产权登记id", example = "102022092209070127")
    private String prrId;
    @ApiModelProperty(value = "材料类型   001身份证   002购房合同   003维修基金   004契税", example = "001")
    private String securities;
    @ApiModelProperty(value = "是否缴费  ture 是   false 否", example = "-1")
    private String isTrue;
    @ApiModelProperty(value = "创建时间", example = "2022-09-22 11:04:57")

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建者", example = "-1")
    private String createUser;
    @ApiModelProperty(value = "statusCd", example = "0")
    private String statusCd;
}
