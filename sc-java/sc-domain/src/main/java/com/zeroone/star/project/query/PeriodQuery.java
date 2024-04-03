package com.zeroone.star.project.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Data
@ApiModel("时间段查询对象")
public class PeriodQuery {

    @ApiModelProperty(value = "起始日期", example = "2022-02-02")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startDate;

    @ApiModelProperty(value = "终止日期", example = "2033-03-03")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endDate;
}
