package com.zeroone.star.project.vo.community.propertyrightregistration;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("楼层显示对象")
public class FloorVO {
    @ApiModelProperty(value = "楼层id", example = "732022100996851030")
    private String floorId;
    @ApiModelProperty(value = "楼层编号", example = "1")
    private String floorNum;
    @ApiModelProperty(value = "社区id", example = "2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "楼栋加入排序",example = "0")
    private Integer seq;
    @ApiModelProperty(value = "备注",example = "Null")
    private String remark;
    @ApiModelProperty(value = "小区楼名称",example = "1号楼")
    private String name;
    @ApiModelProperty(value = "用户名",example = "1号楼")
    private String userName;
    @ApiModelProperty(value = "建筑面积",example = "111.00")
    private Double floorArea;

    /**
     * 用于显示楼层列表
     * @param name
     */
    public FloorVO(String name){
        this.name=name;
    }

}
