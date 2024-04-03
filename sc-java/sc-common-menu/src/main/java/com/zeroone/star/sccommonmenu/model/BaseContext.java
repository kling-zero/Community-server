package com.zeroone.star.sccommonmenu.model;

import lombok.extern.slf4j.Slf4j;

/**
 * 用于保存和获取当前登录的用户id
 */
@Slf4j
public class BaseContext {
    public static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void setCurrentId(String id){
        log.info("currentThread:"+ Thread.currentThread().getId() + ",设置id成功:" + id);
        threadLocal.set(id);
    }
    public static String getCurrentId(){
        log.info("currentThread:"+ Thread.currentThread().getId() + ",获得id成功:" + threadLocal.get());
        return threadLocal.get();
    }

}
