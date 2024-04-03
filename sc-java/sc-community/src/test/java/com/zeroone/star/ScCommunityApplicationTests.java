package com.zeroone.star;

import com.zeroone.star.project.query.community.propertyrightregistration.PRRQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;
import com.zeroone.star.sccommunity.service.prrmanagement.IPRRService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScCommunityApplicationTests {


    private IPRRService service;
    @Test
    void contextLoads()
    {
//        PageVO<PRRVO> vo = service.queryAll(new PRRQuery().setCommunityId());

    }
}
