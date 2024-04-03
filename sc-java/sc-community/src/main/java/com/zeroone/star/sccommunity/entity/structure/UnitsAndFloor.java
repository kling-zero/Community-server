package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

@Data
@TableName("building_unit")
public class UnitsAndFloor {
    //楼ID
    private String floorId;
    //总层数
    private int layerCount;
    //是否有电梯
    private String lift;
    //备注
    private String remark;
    //单元面积
    private Double unitArea;
    //单元ID
    private String unitId;
    //单元编号
    private String unitNum;

    //楼编号,通过楼ID查询
    @TableField(exist = false)
    private String floorNum;
    //楼栋加入排序,通过楼ID查询
    @TableField(exist = false)
    private Integer seq;
}
