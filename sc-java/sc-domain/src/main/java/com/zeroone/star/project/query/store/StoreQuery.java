package com.zeroone.star.project.query.store;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 商户信息查询的查询条件
 * @Author j3小组-黑夜
 */
@ApiModel("商户信息查询条件对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreQuery extends PageQuery {

    @ApiModelProperty(value = "商户名称", example = "哈哈物业")
    private String name;

    @ApiModelProperty(value = "商户类型", example = "其他")
    private String type;

    @ApiModelProperty(value = "联系电话", example = "110")
    private String phone;

}
