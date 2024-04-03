package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.zeroone.star.management.entity.SCommunity;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zeroone.star.management.entity.SCommunityMember;
import com.zeroone.star.management.mapper.MMenuGroupCommunityMapper;
import com.zeroone.star.management.mapper.SCommunityMemberMapper;
import com.zeroone.star.management.service.ISCommunityMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import com.zeroone.star.project.query.management.CommunityQuery;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
@Service
public class SCommunityMemberServiceImpl extends ServiceImpl<SCommunityMemberMapper, SCommunityMember> implements ISCommunityMemberService {

    @Autowired
    SCommunityMemberMapper sCommunityMemberMapper;
    @Autowired
    MMenuGroupCommunityMapper mMenuGroupCommunityMapper;

    @Override
    public int insertISCommunityMemberService(SCommunity communityByName,String memberID) {
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
        SCommunityMember sCommunityMember = new SCommunityMember();
        String communityMemberID = "72" + simpleDateFormat.format(date) +  time;
        String b_id = communityByName.getBId();
        String memberTypeCd = "390001200002";
        LocalDateTime createTime = LocalDateTime.now();
        sCommunityMember.setCommunityId(communityByName.getCommunityId());
        sCommunityMember.setCommunityMemberId(communityMemberID);
        sCommunityMember.setBId(b_id);
        sCommunityMember.setMemberId(memberID);
        sCommunityMember.setMemberTypeCd(memberTypeCd);
        sCommunityMember.setCreateTime(createTime);
        sCommunityMember.setStatusCd("1100");
        sCommunityMember.setStartTime(LocalDateTime.now());
        sCommunityMember.setEndTime(LocalDateTime.now().plusYears(1));
        return sCommunityMemberMapper.insert(sCommunityMember);
    }

    @Override
    public boolean removeCommunity(CommunityQuery communityQuery) {
        //获取选中小区id
        String communityId = communityQuery.getCommunityId();
        //获取选中小区物业Id
        String propertyId = communityQuery.getStoreId();
        //构建更新对象
        LambdaUpdateWrapper<SCommunityMember> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(SCommunityMember::getCommunityId,communityId)
                .eq(SCommunityMember::getMemberId,propertyId)
                .eq(SCommunityMember::getStatusCd,"0")
                .set(SCommunityMember::getStatusCd,1);
        int result = sCommunityMemberMapper.update(null, updateWrapper);
        if (result<1){
            throw new RuntimeException("退出小区失败");
        }

        //逻辑删除该小区的功能
        LambdaUpdateWrapper<MMenuGroupCommunity> mMenuGroupCommunityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        mMenuGroupCommunityLambdaUpdateWrapper.eq(MMenuGroupCommunity::getCommunityId, communityQuery.getCommunityId())
                .eq(MMenuGroupCommunity::getStatusCd,"0")
                .set(MMenuGroupCommunity::getStatusCd,"1");
        mMenuGroupCommunityMapper.update(null, mMenuGroupCommunityLambdaUpdateWrapper);
        return true;
    }
}
