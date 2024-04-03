package com.zeroone.star.scoauth2.service.impl;

import com.zeroone.star.scoauth2.entity.User;
import com.zeroone.star.scoauth2.mapper.UserMapper;
import com.zeroone.star.scoauth2.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 阿伟
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
