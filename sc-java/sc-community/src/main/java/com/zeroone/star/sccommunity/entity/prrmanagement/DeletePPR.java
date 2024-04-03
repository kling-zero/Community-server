package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("property_right_registration")
public class DeletePPR {
    private String prrId;
    private String roomId;
    @TableField(value = "name")
    private String name;
    private LocalDateTime createTime;
    private String link;
    private String idCard;
    private String address;
    private String state;
    private String communityId;


}
