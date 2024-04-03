package com.zeroone.star.project.utils.tree;

/**
 * @Description 对象转换节点数据匹配接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public interface NodeMapper<T> {

    /**
     * 把一个对象转换为节点的数据对象
     *
     * @param object 被转换对象
     * @return 转换后的节点数据
     */
    TreeNode<T> objectMapper(T object);
}
