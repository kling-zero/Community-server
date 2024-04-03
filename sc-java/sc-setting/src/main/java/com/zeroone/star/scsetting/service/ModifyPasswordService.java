package com.zeroone.star.scsetting.service;

/**
 * @author Iris
 * @create 2022-10-16-14:59
 * @email 2015245811@qq.com
 */
public interface ModifyPasswordService {
    /**
     * @param id  用户ID
     * @param passwordOld 用户旧密码
     * @param passwordNew 用户新密码
     * @return int 是否修改成功
     **/
    int ModifyPassword(int id,String passwordOld,String passwordNew);
}
