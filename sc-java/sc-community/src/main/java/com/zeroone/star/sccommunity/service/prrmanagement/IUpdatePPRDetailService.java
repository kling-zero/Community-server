package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.propertyrightregistration.UpdatePPRDetailDTO;

import com.zeroone.star.sccommunity.entity.prrmanagement.UpdatePPRDetail;

public interface IUpdatePPRDetailService extends IService<UpdatePPRDetail> {
    void updateDetail(UpdatePPRDetailDTO condition);
}
