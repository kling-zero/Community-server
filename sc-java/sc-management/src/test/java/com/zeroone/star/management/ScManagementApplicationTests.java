package com.zeroone.star.management;

import com.zeroone.star.management.service.impl.SCommunityServiceImpl;
import com.zeroone.star.management.service.impl.SStoreServiceImpl;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.PropertyVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class cManagementApplicationTests {
    @Autowired
    SCommunityServiceImpl s;
    @Test
    void contextLoads() {
        CommunityQuery query = new CommunityQuery();
        query.setCommunityId("2022083007530003");
        PageVO<SCommunityVO> sCommunityVOPageVO = s.listByCondition(query);
        System.out.println(sCommunityVOPageVO.getRows());
    }

}
