package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.beans.Transient;

/**
 * @Description
 * @Author 业峰
 * @Date 2022/10/19
 */

@Data
@TableName("owner_car")
public class CarStructure{

    @TableField("car_num")
    private String carNum;
    @TableField("owner_id")
    private String ownerId;
    @TableField("community_id")
    private String communityId;
    @TableField("member_id")
    private String memberId;
    @TableField("status_cd")
    private String statusCd;
    @TableField("state")//这个应该是车位状态
    private String state;

    //以下注解在owner_car表中无对应数据，需要多表查询
    //楼编号
    @TableField(exist = false)
    private String floorNum;
    //身份证号码
    @TableField(exist = false)
    private String idCard;
    //联系人手机号
    @TableField(exist = false)
    private String link;
    //欠费金额
    @TableField(exist = false)
    private Double oweAmount;
    //业主名称
    @TableField(exist = false)
    private String ownerName;
    //房屋编号
    @TableField(exist = false)
    private String roomNum;
    //单元ID
    @TableField(exist = false)
    private String unitId;
    //单元编号
    @TableField(exist = false)
    private String unitNum;

}
