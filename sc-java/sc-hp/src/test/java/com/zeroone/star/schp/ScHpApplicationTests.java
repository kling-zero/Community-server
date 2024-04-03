package com.zeroone.star.schp;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.homepage.ComplaintCountVO;
import com.zeroone.star.schp.service.ComplaintService;
import com.zeroone.star.project.vo.homepage.NoticeVO;
import com.zeroone.star.schp.entity.NNotice;
import com.zeroone.star.schp.mapper.NNoticeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScHpApplicationTests {
    @Autowired
    private ComplaintService complaintService;
    @Test
    void test() {
        JsonVO<ComplaintCountVO> complaintCount = complaintService.getComplaintCount();
        System.out.println(complaintCount);


    }

}
