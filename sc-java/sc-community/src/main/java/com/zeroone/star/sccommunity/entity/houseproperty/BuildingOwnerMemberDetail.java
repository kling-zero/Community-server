package com.zeroone.star.sccommunity.entity.houseproperty;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author suqier
 * @since 2022-10-25
 */
@Getter
@Setter
@TableName("building_owner_member_detail")
public class BuildingOwnerMemberDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成员ID
     */
    private String memberId;

    /**
     * 成员姓名
     */
    private String memberName;

    /**
     * 成员身份证号
     */
    private String memberIdCard;

    /**
     * 成员联系方式
     */
    private String memberTel;


}
