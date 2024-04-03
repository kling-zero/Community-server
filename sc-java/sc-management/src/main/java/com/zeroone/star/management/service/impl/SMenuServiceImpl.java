package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.management.entity.MMenu;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.mapper.MMenuGroupMapper;
import com.zeroone.star.management.mapper.SMenuMapper;
import com.zeroone.star.management.service.ISMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.management.SCommunityMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rito
 * @since 2022-10-17
 */
@Service
public class SMenuServiceImpl extends ServiceImpl<SMenuMapper, MMenu> implements ISMenuService {

}
