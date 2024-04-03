package com.zeroone.star.project.query.setting;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.project.dto.setting.vo.dto
 * @Author: sensfloron
 * @CreateTime: 2022-10-16  21:54
 * @Description:  查询员工信息列表条件对象
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("员工信息查询对象")
public class MemberQuery extends PageQuery {

    @ApiModelProperty(value = "员工名称", example = "zhangsan")
    private String name;

    @ApiModelProperty(value = "员工手机号", example = "12341325385")
    private String tel;

    @ApiModelProperty(value = "员工编号ID", example = "302022102655090110")
    private Integer id;


}
