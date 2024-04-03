package com.zeroone.star.sccommunity.entity.houseproperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/22
 */
@Data
public class RoomTreeStructure implements Serializable {
    private String floorId;
    private String floorNum;
    private Integer layer;
    private String link;
    private String ownerId;
    private String ownerName;
    private String roomId;
    private String roomNum;
    private String unitId;
    private String unitNum;
}
