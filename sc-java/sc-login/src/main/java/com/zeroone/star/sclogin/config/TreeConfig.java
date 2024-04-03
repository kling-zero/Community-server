package com.zeroone.star.sclogin.config;

import com.zeroone.star.project.utils.tree.NodeMapper;
import com.zeroone.star.project.utils.tree.TreeNode;
import com.zeroone.star.project.vo.login.MenuTreeVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 实现数据转换为树形节点数据匹配接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Configuration
public class TreeConfig {
    @Bean
    public NodeMapper<MenuTreeVO> createMenuNodeMapper() {
        return menu -> {
            TreeNode<MenuTreeVO> treeNode = new TreeNode<>();
            treeNode.setId(menu.getId());
            treeNode.setText(menu.getName());
            if (menu.getParentMenuId() == null) {
                treeNode.setPid(0);
            } else {
                treeNode.setPid(menu.getParentMenuId());
            }
            treeNode.setRaw(menu);
            treeNode.setHref(menu.getPath());
            treeNode.setIcon(menu.getIcon());
            return treeNode;
        };
    }
}
