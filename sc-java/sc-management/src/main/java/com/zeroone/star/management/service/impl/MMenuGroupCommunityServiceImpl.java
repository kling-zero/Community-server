package com.zeroone.star.management.service.impl;

import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.zeroone.star.management.mapper.MMenuGroupCommunityMapper;
import com.zeroone.star.management.service.IMMenuGroupCommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.entity.SCommunity;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-16
 */
@Service
public class MMenuGroupCommunityServiceImpl extends ServiceImpl<MMenuGroupCommunityMapper, MMenuGroupCommunity> implements IMMenuGroupCommunityService {

    @Autowired
    MMenuGroupCommunityMapper mMenuGroupCommunityMapper;

    @Override
    public int insertMMenuGroupCommunity(String comName,String id,SCommunity sCommunity, MMenuGroup menuGroup) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String gcID;
        String attrID;
        String time = String.valueOf(System.currentTimeMillis());
        time = String.valueOf(System.currentTimeMillis());
        time = time.substring(time.length() - 8);
        gcID = "10" + simpleDateFormat.format(date) +  time;
        MMenuGroupCommunity mMenuGroupCommunity = new MMenuGroupCommunity();
        mMenuGroupCommunity.setGcId(gcID);
        mMenuGroupCommunity.setGId(menuGroup.getGId());
        mMenuGroupCommunity.setName(id);
        mMenuGroupCommunity.setCommunityId(sCommunity.getCommunityId());
        mMenuGroupCommunity.setCommunityName(comName);
        mMenuGroupCommunity.setCommunityId(simpleDateFormat1.format(date));
        mMenuGroupCommunity.setStatusCd("0");
        mMenuGroupCommunity.setCreateTime(LocalDateTime.now());
        return mMenuGroupCommunityMapper.insert(mMenuGroupCommunity);
    }
}
