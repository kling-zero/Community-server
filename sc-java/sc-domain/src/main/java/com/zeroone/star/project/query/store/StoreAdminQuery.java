package com.zeroone.star.project.query.store;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 商户管理员信息查询的查询条件
 * @Author j3小组-安慕希
 */
@ApiModel("商户管理员信息查询条件对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAdminQuery extends PageQuery {

    @ApiModelProperty(value = "物业名称", example = "培训物业公司")
    private String name;

    @ApiModelProperty(value = "管理员", example = "admin")
    private String admin;

    @ApiModelProperty(value = "联系电话", example = "17797173944")
    private String phone;

}
