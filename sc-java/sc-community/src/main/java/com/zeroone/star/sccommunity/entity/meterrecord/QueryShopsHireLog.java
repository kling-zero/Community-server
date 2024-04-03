package com.zeroone.star.sccommunity.entity.meterrecord;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 抄表记录视图对象，房间历史业主，根据小区id、房间num来获取信息
 *
 * @author 业峰
 * @Date 2022 /10/27
 */
@Data
@TableName("business_meter_water")
public class QueryShopsHireLog {
    @TableField(exist = false)
    //只通过building_room来查询所有的userId，再通过批量的id查询其他数据
    private String userId;
    @TableField(exist = false)
    //小区id", example = "2022090665021542")
    private String communityId;
    @TableField(exist = false)
    //创建时间", example = " 2022-10-15 21:24:55")
    private Date createTime;
    @TableField(exist = false)
    //备注", example = "")
    private String remark;
    @TableField(exist = false)
    //", example = "0")
    private String statusCd;

 //business_meter_water，通过fee_id来进行查询
    //本期度数", example = "1001.00")
    private String curDegrees;
    //本期读表时间", example = " 2022-10-15 21:24:50")
    private Date curReadingTime;
    //表类型号", example = "102022090813867155")
    private String meterType;
    //对象名称id", example = "752022100815210720")
    private String objId;
    //对象类型", example = "3333")
    private String objType;
    //上期度数", example = "1000.00")
    private String preDegrees;
    //上期读表时间", example = " 2022-10-08 17:03:53")
    private Date preReadingTime;
    @TableField(exist = false)
    private String meterTypeName;
    //对象名称", example = "1栋0单元9009988室")
    private String objName;
    //", example = "102022101519367873")
    private String waterId;
    //表类型", example = "水费抄表")
    //", example = " 0.0")
    private Integer price;

    //费用id", example = "902022101599537868")
    private String feeId;

    /*数据库没有该字段
    //", example = " 0")
    private Integer records;
     */
}
