package com.zeroone.star.project.components.fastdfs;

import lombok.Builder;
import lombok.Data;

/**
 * @Description dfs文件结果信息
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Data
@Builder
public class FastDfsFileInfo {
    /**
     * 服务器分组
     */
    private String group;
    /**
     * 对应的存储资源ID
     */
    private String storageId;
}
