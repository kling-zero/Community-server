package com.zeroone.star.project.query.community.transactions.buildingfee.feedetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("缴费历史查询数据对象")
public class FeeDetailsQuery extends PageQuery {
    @NotBlank
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;

    @NotBlank
    @ApiModelProperty(value = "费用ID", example = "902022082353800021")
    private String feeId;

    @ApiModelProperty(value = "开始时间", example = "2022-08-01 00:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", example = "2022-09-30 00:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
}
