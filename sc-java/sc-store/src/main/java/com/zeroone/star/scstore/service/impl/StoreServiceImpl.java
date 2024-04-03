package com.zeroone.star.scstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.store.CommunityQuery;
import com.zeroone.star.project.query.store.StoreAdminQuery;
import com.zeroone.star.project.query.store.StoreQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.store.CommunitiesVO;
import com.zeroone.star.project.vo.store.StoreAdminVO;
import com.zeroone.star.project.vo.store.StoreVO;
import com.zeroone.star.scstore.entity.*;
import com.zeroone.star.scstore.mapper.*;
import com.zeroone.star.scstore.service.IStoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author night
 * @since 2022-10-16
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StoreTypeMapper storeTypeMapper;
    @Autowired
    private CommunityMemberMapper communityMemberMapper;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private StoreAttrMapper storeAttrMapper;

    /**
     * 根据条件分页查询商户管理员信息
     * 纯用mp感觉代码略微复杂，准备后面还是用xml写下多表查询sql -- 10.16
     * @param storeAdminQuery 查询条件
     * @return 商户管理员分页对象
     */
    @Override
    public PageVO<StoreAdminVO> getStoreAdminByPageAndCondition(StoreAdminQuery storeAdminQuery) {
        //分页查询对象
        Page<Admin> pageAdmin = new Page<>(storeAdminQuery.getPageIndex(), storeAdminQuery.getPageSize());

        //查询条件 查询所有符合条件物业
        LambdaQueryWrapper<Store> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Store::getStatusCd, "0");
        if (!StringUtils.isEmpty(storeAdminQuery.getName())) {
            wrapper.eq(Store::getName, storeAdminQuery.getName());
        }
        //执行查询
        List<Store> stores = storeMapper.selectList(wrapper);

        //根据用户ID查询用户表 获取管理员信息
        List<Admin> list = stores.stream().map((store) -> {
            //获取用户ID  2表关联
            String userId = store.getUserId();

            //查询条件  查询对应userId的
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getAdminId, userId);
            if (!StringUtils.isEmpty(storeAdminQuery.getAdmin())) {
                queryWrapper.eq(User::getUsername, storeAdminQuery.getAdmin());
            }
            if (!StringUtils.isEmpty(storeAdminQuery.getPhone())) {
                queryWrapper.eq(User::getPhone, storeAdminQuery.getPhone());
            }
            //执行查询
            User user = userMapper.selectOne(queryWrapper);
            if (user == null) {
                return null;
            }

            //赋值给Admin
            Admin admin = new Admin();
            admin.setPropertyCompanyName(store.getName());
            admin.setStatus(store.getState());
            admin.setCreateTime(store.getCreateTime());
            admin.setPropertyId(store.getStoreId());
            BeanUtils.copyProperties(user, admin);

            return admin;
        }).collect(Collectors.toList());
        list.removeAll(Collections.singleton(null));

        pageAdmin.setTotal(list.size());
        if (list.size() > storeAdminQuery.getPageSize()) {
            list = list.subList(0, (int)storeAdminQuery.getPageSize());
        }
        pageAdmin.setRecords(list);
        return PageVO.create(pageAdmin, StoreAdminVO.class);
    }

    /**
     * 获取所有商户类型
     * @return 商户类型 字符串集合
     */
    @Override
    public List<String> getAllTypes() {
        List<StoreType> storeTypes = storeTypeMapper.selectList(null);
        List<String> list = storeTypes.stream().map((item) -> {
            return item.getName();
        }).collect(Collectors.toList());
        return list;
    }

    /**
     * 限制指定ID物业登录
     * @param id 物业ID
     */
    @Override
    public void modifyState(String id) {
        //查询现在的状态
        LambdaQueryWrapper<Store> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Store::getStoreId, id);
        Store store = storeMapper.selectOne(queryWrapper);
        String state = store.getState();

        //如果已被限制就解除，或者相反
        if ("48001".equals(state)) {
            state = "48002";
        } else {
            state = "48001";
        }

        //执行更新
        LambdaUpdateWrapper<Store> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Store::getState, state).eq(Store::getStoreId, id);
        storeMapper.update(null, updateWrapper);
    }

    /**
     * 获取指定ID物业的隶属小区
     * @return 小区VO分页对象
     */
    @Override
    public PageVO<CommunitiesVO> getSubordinations(CommunityQuery communityQuery) {
        //查询所属小区
        LambdaQueryWrapper<CommunityMember> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(CommunityMember::getCommunityId).eq(CommunityMember::getMemberId, communityQuery.getCommunityId());
        List<CommunityMember> communityMembers = communityMemberMapper.selectList(queryWrapper);
        if (communityMembers.size() <= 0) {
            return null;
        }

        //获取所属小区ID集合
        List<String> list = communityMembers.stream().map((member) -> {
            return member.getCommunityId();
        }).collect(Collectors.toList());

        //查询小区信息
        Page<Community> page = new Page<>(communityQuery.getPageIndex(), communityQuery.getPageSize());
        LambdaQueryWrapper<Community> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Community::getCommunityId, list);
        if (!StringUtils.isEmpty(communityQuery.getName())) {
            wrapper.eq(Community::getName, communityQuery.getName());
        }
        Page<Community> communityPage = communityMapper.selectPage(page, wrapper);

        //把状态码改为字符串说明
        for (Community community : communityPage.getRecords()) {
            String state = community.getState();
            if ("1000".equals(state)) {
                state = "待审核";
            } else if ("1100".equals(state)) {
                state = "审核完成";
            } else {
                state = "审核拒绝";
            }
            community.setState(state);
        }

        return PageVO.create(communityPage, CommunitiesVO.class);
    }

    /**
     * 查询商户
     * @param storeQuery 查询条件
     * @return 商户分页对象
     */
    @Override
    public PageVO<StoreVO> getStores(StoreQuery storeQuery) {
        //获取查询条件
        String name = storeQuery.getName();
        String type = storeQuery.getType();
        String phone = storeQuery.getPhone();

        //查询分类的ID
        StoreType storeType = null;
        if (!StringUtils.isEmpty(type)) {
            LambdaQueryWrapper<StoreType> typeQuery = new LambdaQueryWrapper();
            typeQuery.eq(StoreType::getName, type);
            storeType = storeTypeMapper.selectOne(typeQuery);
        }

        //根据名称，分类，电话 查询商户
        Page<Store> storePage = new Page<>(storeQuery.getPageIndex(), storeQuery.getPageSize());
        LambdaQueryWrapper<Store> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.eq(Store::getName, name);
        }
        if (!StringUtils.isEmpty(phone)) {
            queryWrapper.eq(Store::getPhone, phone);
        }
        if (storeType != null) {
            queryWrapper.eq(Store::getType, storeType.getStoreTypeCd());
        }
        Page<Store> stores = storeMapper.selectPage(storePage, queryWrapper);

        //设置商户类型（查出来的是类型ID）
        for (Store store : stores.getRecords()) {
            LambdaQueryWrapper<StoreType> typeQuery = new LambdaQueryWrapper();
            typeQuery.eq(StoreType::getId, store.getType());
            StoreType typeName = storeTypeMapper.selectOne(typeQuery);
            if (typeName != null) {
                store.setType(typeName.getName());
            } else {
                store.setType("其他");
            }
        }


        //设置下成立日期（字段名不一样没法自动封装）
        for (Store store : stores.getRecords()) {
            store.setFoundationDay(store.getCreateTime());
        }
        //查询法人
        for (Store store : stores.getRecords()) {
            String storeId = store.getStoreId();
            LambdaQueryWrapper<StoreAttr> attrQuery = new LambdaQueryWrapper();
            attrQuery.eq(StoreAttr::getStoreId, storeId);
            //这里不知道为什么有的商户会对应多个法人，库里面法人-商户表只有一个，不知道是不是测试数据的BUG
            List<StoreAttr> storeAttrs = storeAttrMapper.selectList(attrQuery);

            //设置法人名字
            if (storeAttrs.size() > 0) {
                StoreAttr storeAttr = storeAttrs.get(0);
                String value = storeAttr.getVALUE();
                System.out.println(value);
                store.setJuridicalPerson(storeAttr.getVALUE());
            } else {
                store.setJuridicalPerson("");
            }
        }

        return PageVO.create(stores, StoreVO.class);
    }
}
