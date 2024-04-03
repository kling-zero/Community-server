package com.zeroone.star.project.query.community.roomRenovation;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("房屋基本信息示例")
public class BasicRenovationQuery extends PageQuery {
    @ApiModelProperty(value = "房屋ID", example = "752021012579820037")
    private String roomId;
    @ApiModelProperty(value = "联系人", example = "杨测试")
    private String personName;
    @ApiModelProperty(value = "房屋名称", example = "15-2-PA001")
    private String roomName;
    @ApiModelProperty(value = "联系人电话", example = "18824674978")
    private String personTel;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "装修开始时间", example = "2021-01-26 00:00:00")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "装修结束时间", example = "2021-03-14 00:00:00")
    private LocalDateTime endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "装修时间", example = "2021-01-26 21:46:10")
    private LocalDateTime  createTime;
    @ApiModelProperty(value = "是否延期", example = "N")
    private String isPostpone;
    @ApiModelProperty(value = "状态", example = "3000")
    private String state;
    @ApiModelProperty(value = "社区ID", example = "2020121530990123")
    private String communityId;
}
