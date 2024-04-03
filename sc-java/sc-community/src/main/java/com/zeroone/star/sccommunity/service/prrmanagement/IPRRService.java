package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zeroone.star.project.dto.community.propertyrightregistration.DeletePPRDTO;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRR;
import org.springframework.stereotype.Repository;


public interface IPRRService extends IService<PRR> {
    PageVO<PRRVO> queryAll(PRRQuery condition);

    int deletePPR(DeletePPRDTO condition);
}
