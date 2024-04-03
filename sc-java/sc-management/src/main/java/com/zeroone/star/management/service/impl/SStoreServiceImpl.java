package com.zeroone.star.management.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.management.entity.*;
import com.zeroone.star.management.mapper.MMenuGroupCommunityMapper;
import com.zeroone.star.management.mapper.SCommunityMapper;
import com.zeroone.star.management.mapper.SCommunityMemberMapper;
import com.zeroone.star.management.mapper.SStoreMapper;
import com.zeroone.star.management.service.*;
import com.zeroone.star.project.dto.management.PropertyDTO;
import com.zeroone.star.project.dto.management.PropertyStateDTO;
import com.zeroone.star.project.dto.management.UpdatePropertyDTO;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.PropertyVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author freazy、jiemo

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j4
 * @since 2022-10-16
 */
@Service
public class SStoreServiceImpl extends ServiceImpl<SStoreMapper, SStore> implements ISStoreService {

    @Autowired
    SStoreMapper storeMapper;
    @Autowired
    SCommunityMapper communityMapper;
    @Resource
    SCommunityMemberMapper communityMemberMapper;
    @Resource
    MMenuGroupCommunityMapper menuGroupCommunityMapper;

    @Autowired
    IUUserService iuUserService;
    @Autowired
    ISStoreUserService isStoreUserService;
    @Autowired
    ICOrdersService icOrdersService;
    @Autowired
    ICBusinessService icBusinessService;
    @Autowired
    ISCommunityService isCommunityService;
    @Autowired
    IMMenuGroupService imMenuGroupService;
    @Autowired
    IMMenuGroupCommunityService imMenuGroupCommunityService;
    @Autowired
    ISCommunityMemberService isCommunityMemberService;

    @Override
    public PageVO<PropertyVO> listPropertyByCondition(PropertyQuery condition) {
        Page<SStore> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        Page<SStore> result = storeMapper.listPropertyByCondition(page, condition);
        System.out.println(result.getRecords());
        return PageVO.create(result, PropertyVO.class);
    }

    @Override
    public String randomUpdatePwd(PropertyDTO propertyDTO) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("store_id",propertyDTO.getStoreId());
        qw.eq("user_id",propertyDTO.getUserId());
        qw.eq("rel_cd", "600311000001");
        qw.eq("status_cd","0");
        SStoreUser one = isStoreUserService.getOne(qw);
        if(ObjectUtil.isNull(one)){
            return null;
        }
        try { //修改user密码
            String pwd = getRandomCode(6);
            UpdateWrapper uw = new UpdateWrapper();
            uw.eq("user_id",propertyDTO.getUserId());
            uw.set("password",  passwdMd5(pwd));
            boolean update = iuUserService.update(uw);
            if(update){
                return pwd;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String saveCommunity(PropertyDTO propertyDTO) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = DateUtil.offset(DateUtil.date(), DateField.YEAR, 1).toLocalDateTime();
        //添加c_order数据
        COrders cOrders = new COrders();
        cOrders.setOId("10"+getDateRandomCode());
        cOrders.setAppId("8000418004");
        cOrders.setExtTransactionId(IdUtil.randomUUID());
        SStore sstore = baseMapper.selectOne(new QueryWrapper<SStore>().eq("store_id", propertyDTO.getStoreId()));
        cOrders.setUserId(sstore.getUserId());
        cOrders.setRequestTime(DateUtil.now().replace(" ","").replace("-","").replace(":",""));
        cOrders.setOrderTypeCd("D");
        cOrders.setFinishTime(LocalDate.parse(DateUtil.today()));
        cOrders.setStatusCd("C");
        cOrders.setCreateTime(now);
        boolean save = icOrdersService.save(cOrders);

        //添加c_business数据
        CBusiness cBusiness = new CBusiness();
        cBusiness.setBId("20"+getDateRandomCode());
        cBusiness.setOId(cOrders.getOId());
        cBusiness.setBusinessTypeCd("500100030002");
        cBusiness.setFinishTime(LocalDate.parse(DateUtil.today()));
        cBusiness.setStatusCd("C");
        cBusiness.setCreateTime(now);
        boolean save1 = icBusinessService.save(cBusiness);
        //添加m_menu_group_community数据
        String communityId = propertyDTO.getCommunityIds().get(0);
        SCommunity community = isCommunityService.getOne(new QueryWrapper<SCommunity>().eq("community_id", communityId));
        Map<String,String> map = new HashMap();
        List<MMenuGroup> list = imMenuGroupService.list();
        for (MMenuGroup mMenuGroup : list) { //获取菜单gid跟name
            map.put(mMenuGroup.getGId(),mMenuGroup.getName());
        }
        MMenuGroupCommunity mMenuGroupCommunity = new MMenuGroupCommunity();
        mMenuGroupCommunity.setCommunityId(communityId);
        mMenuGroupCommunity.setCommunityName(community.getName());
        mMenuGroupCommunity.setCreateTime(now);
        List<String> groupIds = propertyDTO.getGroupIds();
        for (String groupId:groupIds){  //遍历传入的groupids来添加到mMenuGroupCommunity数据
            mMenuGroupCommunity.setGcId("10"+getDateRandomCode());
            mMenuGroupCommunity.setGId(groupId);
            mMenuGroupCommunity.setName(map.get(groupId));
            imMenuGroupCommunityService.save(mMenuGroupCommunity);
        }
        //添加数据s_community_member
        SCommunityMember sCommunityMember = new SCommunityMember();
        sCommunityMember.setCommunityMemberId("10"+getDateRandomCode());
        sCommunityMember.setBId(cBusiness.getBId());
        sCommunityMember.setCommunityId(communityId);
        sCommunityMember.setMemberTypeCd("390001200002");
        sCommunityMember.setMemberId(propertyDTO.getStoreId());
        sCommunityMember.setStatusCd("0");
        sCommunityMember.setAuditStatusCd("1100");
        sCommunityMember.setCreateTime(now);
        sCommunityMember.setStartTime(now);
        sCommunityMember.setEndTime(endTime);
        isCommunityMemberService.save(sCommunityMember);
        return "成功";
    }

    public static String passwdMd5(String str) throws UnsupportedEncodingException {
        return md5(md5(str + "hc@java110"));
    }


    public static String md5(String instr) throws UnsupportedEncodingException {
        try {
            return  DigestUtil.md5Hex(instr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
           throw new UnsupportedEncodingException("md5签名过程错误");
        }
    }

    /**
     * 生成日期+8位随机数
     * @return
     */
    public static String getDateRandomCode(){
        return DateUtil.today().replace("-","")+getRandomCode(8);
    }

    /**
     * 生成随机数
     * @param bit 位数
     * @return 随机数
     */
    public static String getRandomCode(int bit) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < bit; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    @Override
    public int insertProperty(PropertyDTO propertyDTO) {
        //插入新物业信息
        SStore sStore = new SStore();
        sStore.setStoreId("10"+getDateRandomCode());
        sStore.setAddress(propertyDTO.getAddress());
        sStore.setUserId("30518939884421922816");//待修进
        sStore.setName(propertyDTO.getStoreName());
        sStore.setTel(propertyDTO.getTel());
        sStore.setStoreTypeCd("800900000003");
        sStore.setCreateTime(LocalDateTime.now());
        sStore.setState("48001");
        sStore.setStoreTypeCd("0");
        sStore.setMapX("");
        sStore.setMapY("");
        sStore.setNearbyLandmarks(propertyDTO.getNearybyLandmarks());
        int insert = storeMapper.insert(sStore);

        //插入新物业管理的小区的功能
        //获取g_id对应的功能名
        Map<String,String> map = new HashMap();
        List<MMenuGroup> list = imMenuGroupService.list();
        for (MMenuGroup mMenuGroup : list) { //获取菜单gid跟name
            map.put(mMenuGroup.getGId(),mMenuGroup.getName());
        }

        //将新的功能菜单加入m_menu_group_community
        MMenuGroupCommunity mMenuGroupCommunity = new MMenuGroupCommunity();
        LocalDateTime now = LocalDateTime.now();
        mMenuGroupCommunity.setCreateTime(now);
        for (int i=0;i<propertyDTO.getCommunityIds().size();i++){
            mMenuGroupCommunity.setCommunityId(propertyDTO.getCommunityIds().get(i));
            SCommunity community = communityMapper.selectOne(new QueryWrapper<SCommunity>().eq("community_id", propertyDTO.getCommunityIds().get(i)));
            String communityName = community.getName();
            for (String groupId:propertyDTO.getGroupIds()){  //遍历传入的groupids来添加到mMenuGroupCommunity数据
                mMenuGroupCommunity.setGcId("10"+getDateRandomCode());
                mMenuGroupCommunity.setGId(groupId);
                mMenuGroupCommunity.setName(map.get(groupId));
                mMenuGroupCommunity.setCommunityName(communityName);
                imMenuGroupCommunityService.save(mMenuGroupCommunity);
            }
        }
        return insert;
    }

    @Override
    public int updatePropertyByID(UpdatePropertyDTO updatepropertyDTO) {
        UpdateWrapper<SStore> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("address",updatepropertyDTO.getAddress())
                .set("name",updatepropertyDTO.getName())
                .set("tel",updatepropertyDTO.getTel())
                .set("nearby_landmarks",updatepropertyDTO.getNearybyLandmarks())
                .eq("store_id",updatepropertyDTO.getStoreId());

        int i = storeMapper.update(null,updateWrapper);
        return i;
    }

    @Override
    public boolean updateState(PropertyStateDTO propertyStateDTO) {
        //取出状态码和物业公司id
        if (BeanUtil.isEmpty(propertyStateDTO.getState()) || BeanUtil.isEmpty(propertyStateDTO.getStoreId())) {
            return false;
        }
        String storeId = propertyStateDTO.getStoreId();
        String state = propertyStateDTO.getState();
        //创建物业公司对象
        SStore store = new SStore();
        //设置属性
        store.setStoreId(storeId);
        store.setState(state);
        //修改状态
        return baseMapper.updateById(store) > 0;
    }

    @Override
    @Transactional
    public boolean removePropertyById(String storeId) {
        //删除条件
        UpdateWrapper<SStore> storeWrapper = new UpdateWrapper<>();
        storeWrapper.eq("store_id", storeId)
                .eq("status_cd", "0")
                .set("status_cd", "1");
        //根据物业id删除物业
        int update = storeMapper.update(null,storeWrapper);
        if (update < 1) {
            throw new RuntimeException("删除物业失败");
        }

        //获取关联小区
        QueryWrapper<SCommunityMember> communityMemberQueryWrapper = new QueryWrapper<>();
        communityMemberQueryWrapper.eq("member_id", storeId)
                .eq("member_type_cd", "390001200002")
                .eq("status_cd", "0");
        List<SCommunityMember> sCommunityMembers = communityMemberMapper.selectList(communityMemberQueryWrapper);

        //逻辑删除 s_community_memeber 里与该物业相关的小区数据
        UpdateWrapper<SCommunityMember> communityMemberUpdateWrapper = new UpdateWrapper<>();
        communityMemberUpdateWrapper.eq("member_id", storeId)
                .eq("status_cd", "0")
                .set("status_cd", "1");
        int memberUpdate = communityMemberMapper.update(null,communityMemberUpdateWrapper);



        //逻辑删除 m_menu_group_commity 里删除 物业管理的小区 的功能数据
        for (SCommunityMember c:sCommunityMembers) {
            UpdateWrapper<MMenuGroupCommunity> mMenuGroupCommunityUpdateWrapper = new UpdateWrapper<>();
            mMenuGroupCommunityUpdateWrapper.eq("community_id", c.getCommunityId())
                    .eq("status_cd", "0")
                    .set("status_cd", "1");
            int menuGroupUpdate = menuGroupCommunityMapper.update(null,mMenuGroupCommunityUpdateWrapper);
        }



//        //遍历删除小区菜单组权限
//        sCommunityMembers.stream().forEach(sCommunityMember1 -> {
//            //构造小区菜单组对象
//            MMenuGroupCommunity menuGroupCommunity = new MMenuGroupCommunity();
//            menuGroupCommunity.setStatusCd("1");
//            //构造小区菜单组修改条件
//            QueryWrapper<MMenuGroupCommunity> menuGroupCommunityQueryWrapper = new QueryWrapper<>();
//            menuGroupCommunityQueryWrapper.eq("community_id", sCommunityMember1.getCommunityId());
//            //释放小区菜单权限组
//            int flag = menuGroupCommunityMapper.update(menuGroupCommunity, menuGroupCommunityQueryWrapper);
//            if (flag < 1) {
//                throw new RuntimeException("删除小区菜单组权限失败");
//            }
//        });
        return true;
    }

    @Override
    public PageVO<SCommunityVO> queryBelongingCommunities(CommunityQuery communityQuery) {
        Page<SCommunity> page = new Page<>(communityQuery.getPageIndex(), communityQuery.getPageSize());
        Page<SCommunity> sCommunityPage = storeMapper.queryBelongingCommunities(page, communityQuery);//分页查询
        return PageVO.create(sCommunityPage, SCommunityVO.class);
    }
}
