package com.zeroone.star.project.vo.homepage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @Description 首页-小区公告对象
 * @Author j3小组-黑夜
 */
@ApiModel("小区公告(一条,不是公告板整体)对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO {

    @ApiModelProperty(value = "公告内容", example = "<p>小区门口发放免费气球<p>")
    private String message;

    @ApiModelProperty(value = "公告发布时间", example = "2023-01-01 23:00:05")
    private LocalDateTime releaseDate;

}
