package com.zeroone.star.scoauth2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Description 权限认证用户实体
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@Getter
@Setter
@ToString
public class SecurityUser extends org.springframework.security.core.userdetails.User {
    /**
     * 关联一个用户对象
     */
    private User user;

    /**
     * 构造初始化
     *
     * @param user        数据库的User对象
     * @param authorities 权限列表
     */
    public SecurityUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }
}
