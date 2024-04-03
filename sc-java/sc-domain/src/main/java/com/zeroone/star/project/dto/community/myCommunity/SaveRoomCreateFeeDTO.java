package com.zeroone.star.project.dto.community.myCommunity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */

@Data
@ApiModel("创建费用传输数据对象")
public class SaveRoomCreateFeeDTO {
    @ApiModelProperty(value = "",example = "")
    private Double amount;
}
