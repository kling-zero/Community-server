package com.zeroone.star.scsetting.config;

import com.zeroone.star.project.vo.setting.OrganizationTreeVO;
import com.zeroone.star.scsetting.util.NodeMapper;
import com.zeroone.star.scsetting.util.TreeNode;
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
    public NodeMapper<OrganizationTreeVO> createOrganizationNodeMapper() {
        return organization -> {
            TreeNode<OrganizationTreeVO> treeNode = new TreeNode<>();
            treeNode.setId(organization.getOrgId());
            treeNode.setText(organization.getOrgName());
            if (organization.getParentOrgId() == null) {
                treeNode.setPid("0");
            } else {
                treeNode.setPid(organization.getParentOrgId());
            }
            treeNode.setRaw(organization);
            return treeNode;
        };
    }
}
