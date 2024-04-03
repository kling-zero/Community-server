package com.zeroone.star.repair.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName r_repair_setting
 */
@TableName(value ="r_repair_setting")
@Data
public class RRepairSetting implements Serializable {
    /**
     * 工单设置ID
     */
    private String settingId;

    /**
     * 业务ID
     */
    private String bId;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 报修类型名称
     */
    private String repairTypeName;

    /**
     * 派单方式 t_dict 100 抢单 200 指派 300 轮训
     */
    private String repairWay;

    /**
     * 小区分片ID
     */
    private String communityId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据状态
     */
    private String statusCd;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否为公共区域
     */
    private String publicArea;

    /**
     * 是否收费 T为是 F为否
     */
    private String payFeeFlag;

    /**
     * 收费范围，如30元至50元
     */
    private String priceScope;

    /**
     * 回访标识 001 都不回访 002 已评价不回访 003 都回访
     */
    private String returnVisitFlag;

    /**
     * 报修设置类型
     */
    private String repairSettingType;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RRepairSetting other = (RRepairSetting) that;
        return (this.getSettingId() == null ? other.getSettingId() == null : this.getSettingId().equals(other.getSettingId()))
            && (this.getbId() == null ? other.getbId() == null : this.getbId().equals(other.getbId()))
            && (this.getRepairType() == null ? other.getRepairType() == null : this.getRepairType().equals(other.getRepairType()))
            && (this.getRepairTypeName() == null ? other.getRepairTypeName() == null : this.getRepairTypeName().equals(other.getRepairTypeName()))
            && (this.getRepairWay() == null ? other.getRepairWay() == null : this.getRepairWay().equals(other.getRepairWay()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatusCd() == null ? other.getStatusCd() == null : this.getStatusCd().equals(other.getStatusCd()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPublicArea() == null ? other.getPublicArea() == null : this.getPublicArea().equals(other.getPublicArea()))
            && (this.getPayFeeFlag() == null ? other.getPayFeeFlag() == null : this.getPayFeeFlag().equals(other.getPayFeeFlag()))
            && (this.getPriceScope() == null ? other.getPriceScope() == null : this.getPriceScope().equals(other.getPriceScope()))
            && (this.getReturnVisitFlag() == null ? other.getReturnVisitFlag() == null : this.getReturnVisitFlag().equals(other.getReturnVisitFlag()))
            && (this.getRepairSettingType() == null ? other.getRepairSettingType() == null : this.getRepairSettingType().equals(other.getRepairSettingType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSettingId() == null) ? 0 : getSettingId().hashCode());
        result = prime * result + ((getbId() == null) ? 0 : getbId().hashCode());
        result = prime * result + ((getRepairType() == null) ? 0 : getRepairType().hashCode());
        result = prime * result + ((getRepairTypeName() == null) ? 0 : getRepairTypeName().hashCode());
        result = prime * result + ((getRepairWay() == null) ? 0 : getRepairWay().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatusCd() == null) ? 0 : getStatusCd().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPublicArea() == null) ? 0 : getPublicArea().hashCode());
        result = prime * result + ((getPayFeeFlag() == null) ? 0 : getPayFeeFlag().hashCode());
        result = prime * result + ((getPriceScope() == null) ? 0 : getPriceScope().hashCode());
        result = prime * result + ((getReturnVisitFlag() == null) ? 0 : getReturnVisitFlag().hashCode());
        result = prime * result + ((getRepairSettingType() == null) ? 0 : getRepairSettingType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", settingId=").append(settingId);
        sb.append(", bId=").append(bId);
        sb.append(", repairType=").append(repairType);
        sb.append(", repairTypeName=").append(repairTypeName);
        sb.append(", repairWay=").append(repairWay);
        sb.append(", communityId=").append(communityId);
        sb.append(", remark=").append(remark);
        sb.append(", statusCd=").append(statusCd);
        sb.append(", createTime=").append(createTime);
        sb.append(", publicArea=").append(publicArea);
        sb.append(", payFeeFlag=").append(payFeeFlag);
        sb.append(", priceScope=").append(priceScope);
        sb.append(", returnVisitFlag=").append(returnVisitFlag);
        sb.append(", repairSettingType=").append(repairSettingType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}