package com.zeroone.star.sclogin.utils;

import com.zeroone.star.project.constant.RedisConstant;

import java.util.Random;

/**
 * 一些声明信息
 * Description: 通用工具类
 * date: 2022/10/17 上午 10:43
 * @author Suci
 */
public class CommonUtils {

    /**
     * @author Suci
     * @createTime 下午 2:39
     * @desc 生成验证码
     */
    public static String generateCaptcha() {
        // 1. 定义一个随机生成数技术，用来生成随机数
        Random random = new Random();

        // 2. 用String常用API-charAit生成验证码
        String seed = "1234567890abcdefghijklmnopqrstuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";//定义一个String变量存放需要的数据，一共58位

        // 3. 定义一个空的Atring变量用来接收生成的验证码
        String captcha = "";
        // 生成验证码
        for (int i = 0; i < 4; i++) {
            int a = random.nextInt(58);//随机生成0-57之间的数，提供索引位置
            captcha += seed.charAt(a);//用get 和提供的索引找到相应位置的数据给变量
        }

        return captcha;
    }


    /**
     * @author Suci
     * @createTime 下午 2:40
     * @desc 生成RedisKey
     * @param prefix
     * @param info
     * @return String
     */
    public static String generateRedisKey(String prefix, String info) {
        return prefix + ":" + info;
    }


    /**
     * @author Suci
     * @createTime 2022/10/20 下午 6:26
     */
    public static String genereateRedisTokenKey(String token) {
        return RedisConstant.USER_TOKEN + ":" + token;
    }
}
