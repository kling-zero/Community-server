package com.zeroone.star.project.query.acceptHouseProperty;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/17
 */

@Data
@ApiModel("付费查询对象")
public class RoomCreateFeeAddQuery extends PageQuery {
    @NotBlank(message = "小区ID不能为空")
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @NotBlank(message = "费用类型不能为空")
    @ApiModelProperty(value = "费用类型",example = "物业费")
    private String feeTypeCd;
    @NotBlank(message = "默认费用不能为空")
    @ApiModelProperty(value = "默认费用",example = "T")
    private String isDefault;
    @NotBlank(message = "有效期不能为空")
    @ApiModelProperty(value = "有效期",example = "1")
    private String valid;
}
