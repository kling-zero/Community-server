package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.management.entity.CBusiness;
import com.zeroone.star.management.entity.SCommunity;
import com.zeroone.star.management.mapper.CBusinessMapper;
import com.zeroone.star.management.mapper.SCommunityMapper;
import com.zeroone.star.management.service.ISCommunityService;
import com.zeroone.star.project.vo.management.SCommunityVO;
import org.springframework.beans.factory.annotation.Autowired;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.vo.PageVO;
import org.apache.commons.lang.StringUtils;
import com.zeroone.star.project.dto.management.CommunityDTO;
import com.zeroone.star.project.dto.management.ModifyCommunityDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-16
 */
@Service
public class SCommunityServiceImpl extends ServiceImpl<SCommunityMapper, SCommunity> implements ISCommunityService {
    @Autowired
    SCommunityMapper communityMapper;

    @Autowired
    CBusinessMapper cBusinessMapper;

    @Override
    public List<SCommunityVO> selectNoEnterCommunity() {
        return communityMapper.selectNoEnterCommunity();
    }

    @Override
    public boolean saveCommunity(CommunityDTO communityDTO) {
        SCommunity sCommunity = new SCommunity();
        CBusiness cBusiness = new CBusiness();

        Integer random = (new Random().nextInt(89999999)) + 10000000;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = simpleDateFormat.format(new Date());

        //id生成规则 功能号+日期+8位随机数
        //communityId
        sCommunity.setCommunityId(date + random);
        //b_id
        cBusiness.setBId("20" + date + random);
        //o_id
        cBusiness.setOId("10" + date + random);

        //表c_business
        cBusiness.setCreateTime(LocalDateTime.now());
        //保存小区信息类型代码
        cBusiness.setBusinessTypeCd("500100030001");
        //业务完成时间
        cBusiness.setFinishTime(LocalDate.now());
        //备注无 此处不进行设置
        //数据状态，详细参考c_status表 C代表订单完成
        cBusiness.setStatusCd("C");

        //表s_community
        //创建sCommunity实体类
        sCommunity.setName(communityDTO.getCommunityName());
        sCommunity.setAddress(communityDTO.getAddress());
        sCommunity.setNearbyLandmarks(communityDTO.getNearbyLandmarks());
        //int转string
        sCommunity.setCityCode((communityDTO.getCityCode()).toString());
        //tel转string
        sCommunity.setTel(communityDTO.getTel().toString());
        //int转long
        sCommunity.setPayFeeMonth(communityDTO.getPayFeeMonth().longValue());
        //float转bigdecimal
        sCommunity.setFeePrice(
                new BigDecimal(
                        Float.toString(
                                communityDTO.getFeePrice())));
        //生成现在创造的时间
        sCommunity.setCreateTime(LocalDateTime.now());
        //日后实现坐标
        sCommunity.setMapX("");
        sCommunity.setMapY("");

        return cBusinessMapper.insert(cBusiness) == 1 && communityMapper.insert(sCommunity) == 1;
    }

    @Override
    public boolean updateCommunity(ModifyCommunityDTO communityDTO) {
        SCommunity sCommunity = new SCommunity();
        CBusiness cBusiness = new CBusiness();

        Integer random = (new Random().nextInt(89999999)) + 10000000;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = simpleDateFormat.format(new Date());

        //b_id
        cBusiness.setBId("20" + date + random);
        //o_id
        cBusiness.setOId("10" + date + random);
        //表c_business
        cBusiness.setCreateTime(LocalDateTime.now());
        //修改小区信息类型代码
        cBusiness.setBusinessTypeCd("500100040001");
        //业务完成时间
        cBusiness.setFinishTime(LocalDate.now());
        //备注无 此处不进行设置
        //数据状态，详细参考c_status表 C代表订单完成
        cBusiness.setStatusCd("C");

        //表s_community
        sCommunity.setCommunityId(communityDTO.getCommunityId());
        sCommunity.setName(communityDTO.getName());
        sCommunity.setAddress(communityDTO.getAddress());
        sCommunity.setNearbyLandmarks(communityDTO.getNearbyLandmarks());
        sCommunity.setCityCode((communityDTO.getCityCode()).toString());
        sCommunity.setTel((communityDTO.getTel()).toString());
        sCommunity.setPayFeeMonth(communityDTO.getPayFeeMonth().longValue());
        sCommunity.setFeePrice(
                new BigDecimal(
                        Float.toString(
                                communityDTO.getFeePrice())));


        return cBusinessMapper.insert(cBusiness) == 1 && communityMapper.updateById(sCommunity) == 1;
    }


    @Override
    public PageVO<SCommunityVO> listByCondition(CommunityQuery condition) {
        //分页对象
        Page<SCommunity> page = new Page<>(condition.getPageIndex(),condition.getPageSize());
        //条件对象
        QueryWrapper<SCommunity> queryWrapper = new QueryWrapper<>();
        //添加判断条件
        queryWrapper
                .like(StringUtils.isNotBlank(condition.getCommunityId()),"community_id","%"+condition.getCommunityId()+"%")
                .like(StringUtils.isNotBlank(condition.getName()),"name","%"+condition.getName()+"%")
                .eq(condition.getCityCode() != null,"city_code",condition.getCityCode());
        //执行分页查询
        Page<SCommunity> res = communityMapper.selectPage(page, queryWrapper);

        return PageVO.create(res, SCommunityVO.class);
    }

    @Override
    public SCommunity getCommunityByName(String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        List<SCommunity> mMenus = communityMapper.selectByMap(map);
        if (mMenus != null && mMenus.size() == 1){
            return mMenus.get(0);
        }else{
            return null;
        }
    }
}
