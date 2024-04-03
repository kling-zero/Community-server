package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("property_right_registration")
public class Check {
    private String prrId;
    private String roomId;
    @TableField("name")
    private String name;
    private String link;
    private String idCard;
    private String address;
    private LocalDateTime createTime;
    private String state;
    private String communityId;
    private String remark;
}
