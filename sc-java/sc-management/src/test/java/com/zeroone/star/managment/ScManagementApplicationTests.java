package com.zeroone.star.managment;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.management.ScManagementApplication;
import com.zeroone.star.management.entity.MMenuGroup;
import com.zeroone.star.management.entity.MMenuGroupCommunity;
import com.zeroone.star.management.service.IMMenuGroupCommunityService;
import com.zeroone.star.management.service.IMMenuGroupService;
import com.zeroone.star.management.service.impl.SStoreServiceImpl;
import com.zeroone.star.project.dto.management.PropertyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest(classes = ScManagementApplication.class)
class ScManagementApplicationTests {

    @Resource
    SStoreServiceImpl sStoreService;
    @Autowired
    IMMenuGroupService imMenuGroupService;
    @Autowired
    IMMenuGroupCommunityService imMenuGroupCommunityService;
    @Test
    void contextLoads() {
        List<String> group = new ArrayList<>();
        group.add("802022052412780003");
        group.add("802021080609660006");
        group.add("802021012591650002");
        Map<String,String> map = new HashMap();
        List<MMenuGroup> list = imMenuGroupService.list();
        for(MMenuGroup mMenuGroup:list){
            map.put(mMenuGroup.getGId(),mMenuGroup.getName());
        }
        MMenuGroupCommunity mMenuGroupCommunity = new MMenuGroupCommunity();
        mMenuGroupCommunity.setCommunityId("9999");
        mMenuGroupCommunity.setCommunityName("法外狂徒");
        mMenuGroupCommunity.setCreateTime(LocalDateTime.now());
        for (String groupId:group){  //遍历传入的groupids来添加到mMenuGroupCommunity数据
            mMenuGroupCommunity.setGcId("10"+groupId);
            mMenuGroupCommunity.setGId(groupId);
            mMenuGroupCommunity.setName(map.get(groupId));
            imMenuGroupCommunityService.save(mMenuGroupCommunity);
        }

        System.out.println(map.toString());
    }

}
