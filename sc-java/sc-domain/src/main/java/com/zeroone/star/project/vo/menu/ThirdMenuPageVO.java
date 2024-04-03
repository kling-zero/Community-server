package com.zeroone.star.project.vo.menu;

import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel("三级菜单分页展示对象")
@Data
public class ThirdMenuPageVO extends PageVO {

    @ApiModelProperty(value = "编号", example = "1")
    private Integer id;

    @ApiModelProperty(value = "权限名", example = "删除手机菜单权限")
    private String name;

    @ApiModelProperty(value = "链接地址", example = "/admin.html#/pages/admin/housekeepingTypeManage")
    private String linkUrl;

    @ApiModelProperty(value = "商户类型", example = "1")
    private Integer roleId;

    @ApiModelProperty(value = "商户名称", example = "运营团队")
    private String roleName;

    @ApiModelProperty(value = "是否启用 0 禁用 1 启用", example = "1")
    private Integer isEnable;

    @ApiModelProperty(value = "创建时间", example = "2021-11-26 21:18:44")
    private LocalDateTime createTime;
}
