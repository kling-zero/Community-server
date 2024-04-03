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
@TableName("property_right_registration")
public class SavePRR {
    private String prrId;
    private String roomId;
    @TableField("name")
    private String name;
    private String link;
    private String idCard;
    private String address;
    private String state;

    private String createUser="";
    private String statusCd="";

    private String communityId;

    private String isTrue;

    private String floorId;
    private String unitId;

    private List<List<FloorVO>> floors ;
    private List<RoomVO> rooms;
    private List<List<UnitVO>> units;
    private List<String> housePurchasePhotos;
    private List<String> idCardPhotos;
    private List<String> repairPhotos;
    private List<String> deedTaxPhotos;
}
