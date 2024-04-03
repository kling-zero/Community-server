package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.UnitVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("business_property_right_registration")
public class UpdatePPRl {
    private String prrId;
    private String state;
    private String remark;
    private String roomId;
    @TableField(value = "name")
    private String name;
    private String link;
    private String address;
    private String idCard;
}
