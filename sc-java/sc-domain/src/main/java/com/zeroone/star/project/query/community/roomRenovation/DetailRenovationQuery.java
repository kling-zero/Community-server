package com.zeroone.star.project.query.community.roomRenovation;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("房屋详细信息示例")
public class DetailRenovationQuery extends PageQuery {
    @ApiModelProperty(value = "装修ID", example = "172021012639030001")
    private String rId;
    @ApiModelProperty(value = "小区ID", example = "2020121530990123")
    private String communityId;


}
