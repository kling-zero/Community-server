package com.zeroone.star.project.vo.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 商户信息对象
 * @author j3小组-黑夜
 */
@ApiModel("商户信息对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreVO {

    @ApiModelProperty(value = "商户名称", example = "金山物业")
    private String name;

    @ApiModelProperty(value = "商户地址", example = "福建省胡建市金山路")
    private String address;

    @ApiModelProperty(value = "联系电话", example = "13013003100")
    private String phone;

    @ApiModelProperty(value = "商户类型", example = "物业商户")
    private String type;

    @ApiModelProperty(value = "企业法人", example = "大聪明")
    private String juridicalPerson;

    @ApiModelProperty(value = "成立日期", example = "2023-10-01")
    private LocalDateTime foundationDay;
}
