package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description 房屋结构对象
 * @Author 业峰
 * @Date 2022/10/21
 */
@Data
@TableName("building_room")
public class RoomStructure {
    private String apartment;
    private Double builtUpArea;
    private String communityId;
    private LocalDate createTime;
    private String remark;
    private Double feeCoefficient;
    private String layer;
    private Double roomArea;
    private String roomId;
    private String roomNum;
    private String roomSubType;
    private String roomType;
    private Integer section;
    private String state;
    private String statusCd;
    private String unitId;
    //不展示
    private String userId;

    //楼ID
    @TableField(exist = false)
    private String floorId;
    //楼编号", example ="1")
    @TableField(exist = false)
    private String floorNum;
    //身份证号码", example ="1")
    @TableField(exist = false)
    private String idCard;
    //联系人手机号",example = "16602905643")
    @TableField(exist = false)
    private String link;
    //欠费金额",example = "2420.00")
    @TableField(exist = false)
    private Double oweAmount;
    //业主ID",example = "772022100993004972")

    @TableField(exist = false)
    private String ownerId;

    //业主姓名",example = "")
    @TableField(exist = false)
    private String ownerName;
    //租金",example = "1.00")
    @TableField(exist = false)
    private Double roomRent;
    //单元编号",example = "0")
    @TableField(exist = false)
    private String unitNum;
}
