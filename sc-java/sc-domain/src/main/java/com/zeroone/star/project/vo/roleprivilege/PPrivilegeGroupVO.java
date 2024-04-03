package com.zeroone.star.project.vo.roleprivilege;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("角色授权查询显示对象")
public class PPrivilegeGroupVO implements Serializable {
    @ApiModelProperty(value = "权限组ID")
    private String pgId;
    @ApiModelProperty(value = "权限组名称")
    private String name;
    @ApiModelProperty(value = "权限组描述")
    private String description;
    @ApiModelProperty(value = "数据状态，详细参考c_status表，0在用，1失效")
    private String statusCd;
    @ApiModelProperty(value = "商户ID")
    private String storeId;
}
