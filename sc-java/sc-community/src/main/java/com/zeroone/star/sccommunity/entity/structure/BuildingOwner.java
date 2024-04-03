package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.bouncycastle.cms.bc.BcKeyTransRecipientInfoGenerator;

/**
 * @Author：业峰
 * 业主属性
 */
@Data
@TableName("building_owner")
public class BuildingOwner {
    //业主成员ID
    @TableField("member_id")
    private String memberId;
    //业主名称
    private String name;
    //联系人手机号
    private String link;
    //小区ID
    private String communityId;
    //身份证号码
    private String idCard;
    //用户ID
    private String userId;
    //业主IDownerId
    private String ownerId;
}
