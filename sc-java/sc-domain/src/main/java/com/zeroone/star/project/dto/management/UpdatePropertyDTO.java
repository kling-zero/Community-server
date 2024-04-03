package com.zeroone.star.project.dto.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("物业更新传输对象")
public class UpdatePropertyDTO {
    @NotBlank(message = "物业id不能为空")
    @ApiModelProperty(value = "物业id", example = "102022081507340568")
    private String StoreId;


    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(value = "地址", example = "哈哈街吊111号")
    private String address;

    @NotBlank(message = "法人不能为空")
    @ApiModelProperty(value = "公司法人", example = "那么娟")
    private String corporation;


    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称", example = "哈哈物业")
    private String name;

    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话", example = "110")
    private String tel;

    @NotBlank(message = "地标不能为空")
    @ApiModelProperty(value = "地标", example = "智星大厦旁")
    private String nearybyLandmarks;
}
