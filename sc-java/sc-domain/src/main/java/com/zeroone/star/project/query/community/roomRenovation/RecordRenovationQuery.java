package com.zeroone.star.project.query.community.roomRenovation;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("房屋追踪信息示例")
public class RecordRenovationQuery extends PageQuery {
    @ApiModelProperty(value = "装修ID", example = "172021052887380092")
    private String rId;
}