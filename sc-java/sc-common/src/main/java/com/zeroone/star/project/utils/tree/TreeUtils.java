package com.zeroone.star.project.utils.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树形数据构建工具类
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */

public class TreeUtils {

    /**
     * 将列表数据转换成树状数据
     *
     * @param list   列表数据
     * @param mapper 数据转换节点数据匹配接口
     * @param <T>    源数据类型
     * @return 返回树状数据列表
     */
    public static <T> List<TreeNode<T>> listToTree(List<T> list, NodeMapper<T> mapper) {
        // 把集合中的数据转换为树形节点数据
        List<TreeNode<T>> nodes = new ArrayList<>();
        for (T row : list) {
            TreeNode<T> node = mapper.objectMapper(row);
            nodes.add(node);
        }

        // 构建一个具有层次结构的树
        List<TreeNode<T>> tree = new ArrayList<>();
        // 循环获取根节点
        for (TreeNode<T> node : nodes) {
            if (node.getPid().equals(0)) {
                tree.add(node);
                node.setDepth(0);
                // 每个节点查找子节点
                findChildNodes(node, nodes);
            }
        }
        return tree;
    }

    private static <T> void findChildNodes(TreeNode<T> parentNode, List<TreeNode<T>> nodes) {
        for (TreeNode<T> child : nodes) {
            // 找到子节点
            if (parentNode.getId().equals(child.getPid())) {
                // 判断父节点中的子节点集合是否为空
                if (parentNode.getChildren() == null) {
                    parentNode.setChildren(new ArrayList<>());
                }
                // 设置子节点的相关计算数据
                child.setDepth(parentNode.getDepth() + 1);
                // 将子节点添加到父节点的子节点集合中
                parentNode.getChildren().add(child);

                // 查找子节点包含的子节点
                findChildNodes(child, nodes);
            }
        }
    }
}