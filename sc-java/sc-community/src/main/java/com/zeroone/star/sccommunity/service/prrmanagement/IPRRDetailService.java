package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.propertyrightregistration.PRRDetailQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.PRRDetailVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.PRRDetail;

public interface IPRRDetailService extends IService<PRRDetail> {
    PageVO<PRRDetailVO> queryDetailById(PRRDetailQuery condition);
}
