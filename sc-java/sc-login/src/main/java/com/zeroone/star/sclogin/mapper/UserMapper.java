package com.zeroone.star.sclogin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.sclogin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 阿伟
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
