package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 业峰
 * @since 2022-10-08
 * 维修池对应的实体类
 */
@Data
@TableName("r_repair_pool")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableField("repair_id")
    private String repairId;
    //需根据id查表确定
    //@TableField("community_id")
    private String communityId;
    //需根据id查表确定
    private String repairType;
    private String repairName;
    private String tel;
    private Date appointmentTime;
    //需根据id查表确定
    private String state;


}
