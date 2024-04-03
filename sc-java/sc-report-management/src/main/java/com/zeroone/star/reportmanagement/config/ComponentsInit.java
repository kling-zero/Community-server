package com.zeroone.star.reportmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 组件初始化
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Configuration
@ComponentScan({
        "com.zeroone.star.project.components.fastdfs",
        "com.zeroone.star.project.components.easyexcel"
})
public class ComponentsInit {
}
