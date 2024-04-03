package com.zeroone.star.project.oauth;

import java.util.Map;

/**
 * @Description 密钥接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public interface KeyPairApis {
    /**
     * 获取公钥
     * @return 返回公钥数据
     */
    Map<String, Object> getPublicKey();

    /**
     * 获取私钥
     * @return 返回私钥数据
     */
    Map<String, Object> getPrivateKey();
}
