package com.zeroone.star.project.query.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/16
 */

@Data
@ApiModel("拥有者选择查询对象")
public class OwnersQuery extends PageVO {
    @NotBlank(message = "业主ID不能为空")
    @ApiModelProperty(value = "业主ID", example ="772022081789310004")
    private String ownerId;
    @NotBlank(message = "成员ID不能为空")
    @ApiModelProperty(value = "成员ID",example = "302022081574590429")
    private String memberId;

}
