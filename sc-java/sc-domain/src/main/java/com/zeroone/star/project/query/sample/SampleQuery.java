package com.zeroone.star.project.query.sample;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @Description 示例查询对象
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("示例查询对象")
public class SampleQuery extends PageQuery {

    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;

    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "省份", example = "青海省")
    private String province;

    @ApiModelProperty(value = "城市", example = "西宁市")
    private String city;

    @ApiModelProperty(value = "城市", example = "西宁市")
    private String county;
}
