package com.zeroone.star.sclogin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sclogin.entity.User;
import com.zeroone.star.sclogin.mapper.UserMapper;
import com.zeroone.star.sclogin.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * date: 2022/10/26 下午 3:22
 *
 * @author Four
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
