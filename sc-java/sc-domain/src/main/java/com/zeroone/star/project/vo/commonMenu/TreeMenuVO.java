package com.zeroone.star.project.vo.commonMenu;

import com.zeroone.star.project.vo.TreeNodeVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeMenuVO implements Serializable {
    @ApiModelProperty(value = "唯一ID", example = "1")
    private Integer id;
    @ApiModelProperty(value = "节点源数据对象")
    private String name;
    @ApiModelProperty(value = "节点链接地址", example = "menuManagement")
    private String linkUrl;
    @ApiModelProperty(value = "方法", example = "")
    private String path;
    @ApiModelProperty(value = "节点对应图标", example = "fa-user-md")
    private String icon;
    @ApiModelProperty(value = "节点父节点ID", example = "null")
    private Integer pid;
    @ApiModelProperty(value = "描述信息", example = "")
    private String description;
    @ApiModelProperty(value = "节点深度", example = "1")
    private Integer level;
    @ApiModelProperty(value = "是否展开", example = "false")
    private Boolean expanded;
    @ApiModelProperty(value = "是否选中", example = "false")
    private Boolean checked;
    @ApiModelProperty(value = "节点包含的子节点")
    private List<TreeNodeVO> children;

}
