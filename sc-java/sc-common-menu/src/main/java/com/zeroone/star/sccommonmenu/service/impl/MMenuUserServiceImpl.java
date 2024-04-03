package com.zeroone.star.sccommonmenu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.commonMenu.MMenuUserDTO;
import com.zeroone.star.project.query.commonMenu.MMenuUserQuery;
import com.zeroone.star.project.vo.commonMenu.MMenuUserVO;
import com.zeroone.star.sccommonmenu.entity.MMenuUser;
import com.zeroone.star.sccommonmenu.mapper.MMenuUserMapper;
import com.zeroone.star.sccommonmenu.model.constant.CommonMenuConstant;
import com.zeroone.star.sccommonmenu.model.redisMtehods.RedisUtils;
import com.zeroone.star.sccommonmenu.service.IMMenuUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author j1-tao
 * @since 2022-10-15
 */
@Slf4j
@Service
public class MMenuUserServiceImpl extends ServiceImpl<MMenuUserMapper, MMenuUser> implements IMMenuUserService {
    @Autowired
    private MMenuUserMapper mMenuUserMapper;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 分页查询当前用户的常用菜单
     * @param mMenuUserQuery
     * @return
     */
    @Override
    public List<MMenuUserVO> listMenuUser(MMenuUserQuery mMenuUserQuery, String userId) {
        //获得当前线程下的staffId
        String staffId = userId;

        //分页查询条件
//        long pageIndex = mMenuUserQuery.getPageIndex();
//        long pageSize = mMenuUserQuery.getPageSize();
//        Page page = new Page(pageIndex, pageSize);

        String muId = mMenuUserQuery.getMuId();
        String name = mMenuUserQuery.getName();
        Integer seq = mMenuUserQuery.getSeq();
        String seqString = seq==null? null:String.valueOf(seq);

        //查询条件
        Map<SFunction<MMenuUser,?>, String> ssMap = new HashMap<>();
        ssMap.put(MMenuUser::getMuId,muId);
        ssMap.put(MMenuUser::getName,name);
        ssMap.put(MMenuUser::getSeq,seqString);
        
        ssMap.put(MMenuUser::getStatusCd,String.valueOf(0));
        ssMap.put(MMenuUser::getStaffId,staffId);

        LambdaQueryWrapper<MMenuUser> mmuLW = new LambdaQueryWrapper();
        //设置没有就忽略
        mmuLW.allEq(ssMap,false);
        //根据seq升序
        mmuLW.orderByAsc(MMenuUser::getSeq);

        //分页查询
//        Page pages = this.page(page, mmuLW);
//        List<MMenuUser> records = pages.getRecords();
        List<MMenuUser> mMenuUserList = this.list(mmuLW);
        log.info(mMenuUserList.toString());

        //数据处理
        int recordsLen = mMenuUserList.size();
        List<MMenuUserVO> mMenuUserVOList = new ArrayList<>(recordsLen);
        mMenuUserList.stream().forEach(mMenuUser -> {
            MMenuUserVO mMenuUserVO = new MMenuUserVO();
            BeanUtil.copyProperties(mMenuUser, mMenuUserVO);
            mMenuUserVOList.add(mMenuUserVO);
        });

        return mMenuUserVOList;
    }


    /**
     * 为当前用户删除一个菜单
     * @param mMenuUserDTO
     * @return
     */
    @Override
    public Boolean deleteMenuUser(MMenuUserDTO mMenuUserDTO) {
        String muId = mMenuUserDTO.getMuId();
        String staffId = mMenuUserDTO.getStaffId();
        //根据staffId与muId更改
        boolean delete = mMenuUserMapper.changeMMenUserStatusCd(muId, staffId, 1);

        //删除成功就清除缓存
        if(delete){
            String rediskey = CommonMenuConstant.MENU_USER_KEY + staffId;
            //是否存在key
            if(redisUtils.isExist(rediskey)){
                boolean b = redisUtils.deleteKey(rediskey);
                log.info("常用菜单 key:"+ rediskey +":redis删除缓存" + b);
            }
        }
        return delete;
    }

    /**
     * 为当前用户添加一个菜单
     * @param mMenuUserDTO
     * @return
     */
    @Override
    public Boolean saveMenuUser(MMenuUserDTO mMenuUserDTO) {
        //生成添加数据
        MMenuUser mMenuUser = new MMenuUser();
//        mMenuUser.setMId(mMenuUserDTO.getMId());
//        mMenuUser.setStaffId(mMenuUserDTO.getStaffId());
//        mMenuUser.setName(mMenuUserDTO.getName());
//        mMenuUser.setIcon(mMenuUserDTO.getIcon());
//        mMenuUser.setUrl(mMenuUserDTO.getUrl());
//        mMenuUser.setSeq(mMenuUserDTO.getSeq());
        BeanUtils.copyProperties(mMenuUserDTO, mMenuUser);
        mMenuUser.setStatusCd("0");
        boolean save = this.save(mMenuUser);

        //更新redis缓存
        if(save){
            MMenuUserVO mMenuUserVO = new MMenuUserVO();
            BeanUtil.copyProperties(mMenuUser, mMenuUserVO);

            String rediskey = CommonMenuConstant.MENU_USER_KEY + mMenuUserDTO.getStaffId();
            //存在key
            if(redisUtils.isExist(rediskey)){
                boolean insertResult = redisUtils.IntoRedisList(rediskey, mMenuUserVO);
                log.info("常用菜单 key:"+ rediskey +":redis更新缓存" + insertResult);
            }
        }
        return save;
    }


}
