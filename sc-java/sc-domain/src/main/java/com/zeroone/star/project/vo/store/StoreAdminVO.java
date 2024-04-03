package com.zeroone.star.project.vo.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 商户信息查询条件的商户分类对象
 * @Author j3小组-阿V
 */
@ApiModel("商户管理员信息对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAdminVO {

    @ApiModelProperty(value = "物业ID,页面不展示,不过查询隶属小区的时候要传给后端", example = "102022081507340423")
    private String propertyId;

    @ApiModelProperty(value = "所属物业公司名称", example = "培训物业公司")
    private String propertyCompanyName;

    @ApiModelProperty(value = "管理员姓名", example = "admin")
    private String username;

    @ApiModelProperty(value = "管理员ID", example = "302023100149504929")
    private String adminId;

    @ApiModelProperty(value = "管理员电话", example = "13013003100")
    private String phone;

    @ApiModelProperty(value = "状态", example = "0")
    private String status;

    @ApiModelProperty(value = "创建时间", example = "2023-10-01 09:00:00")
    private LocalDateTime createTime;

}
