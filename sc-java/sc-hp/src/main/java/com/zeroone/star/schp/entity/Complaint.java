package com.zeroone.star.schp.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 投诉实体类
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    @TableId
    //投诉ID
    private String complaintId;
    //业务ID
    private String bId;
    //商户ID
    private String storeId;
    //投诉类型，见t_dict表
    private String typeCd;
    //房屋ID
    private String roomId;
    //投诉人
    private String complaintName;
    //投诉人联系方式
    private String tel;
    //投诉内容
    private String context;
    //投诉处理状态，见 t_dict表
    private String state;
    //创建时间
    private Date createTime;
    //数据状态，详细参考t_dict表，0, 在用 1失效
    private String statusCd;
    //小区ID，分片键
    private String communityId;
    //投诉人ID
    private String startUserId;




}

