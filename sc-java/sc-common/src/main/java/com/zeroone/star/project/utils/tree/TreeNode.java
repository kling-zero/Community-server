package com.zeroone.star.project.utils.tree;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 用来定义一个树形节点的数据
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
public class TreeNode<T> implements Serializable {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 节点文本描述
     */
    private String text;
    /**
     * 节点对应图标
     */
    private String icon;
    /**
     * 节点链接地址
     */
    private String href;
    /**
     * 节点父节点ID
     */
    private Integer pid;
    /**
     * 节点深度
     */
    private Integer depth;
    /**
     * 是否展开
     */
    private Boolean expanded;
    /**
     * 是否选中
     */
    private Boolean checked;
    /**
     * 节点包含的子节点
     */
    private List<TreeNode<T>> children;
    /**
     * 节点源数据对象
     */
    private T raw;
}
