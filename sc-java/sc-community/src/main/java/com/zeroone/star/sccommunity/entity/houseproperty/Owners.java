package com.zeroone.star.sccommunity.entity.houseproperty;

import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.OwnerAttrDtos;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/21
 */
@Getter
@Setter
public class Owners implements Serializable {
    private Integer age;
    private LocalDateTime createTime;
    private String idCard;
    private String link;
    private String memberId;
    private String name;
    private List<BuildingOwnerAttr> ownerAttrDtos;
    private String ownerId;
    private String ownerTypeCd;
    private String ownerTypeName;
    private String remark;
    private Integer sex;
    private String userName;
}
